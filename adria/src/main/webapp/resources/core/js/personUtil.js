/**
 * 
 */
personUtil = {};

personUtil.emptyFields = function() {
	$("#completeName").val("");
	$("#phoneNum").val("");
	$("#email").val("");
	$("#id").val("");
}

personUtil.getAll = function() {
	$.ajax({
		method : "GET",
		url : "/adriaexo/persons",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(result) {
			var personsDataTable = $("#personsData");
			personsDataTable.find("tr").remove();
			result.forEach(function(element) {				
				personsDataTable.append("<tr><td style='display:none;'>" + element.id + "</td>\
							<td>" + element.completeName + "</td>\
							<td>" + element.phoneNum + "</td>\
							<td>" + element.email + "</td>\
							<td><button id='" + element.id + "' type='button' class='btn btn-danger deletePerson'>Supprimer</button></td></tr>");
				
				var deleteBtn = $("#"+element.id);
				deleteBtn.click(function(e) {
					e.preventDefault();
		 			personUtil.deletePerson(element.id);
				});
				
			});
		}
	})
		.fail(function() {
			throw "Il y a eu un problème lors du chargement des données depuis la source.";
		})
}

personUtil.save = function(personObj) {
	$.post({
		url : '/adriaexo/addPerson',
		data : personObj,
		success : function(res) {
			if (res.validated) {
				personUtil.emptyFields();
				personUtil.getAll();
			} else {
				$.each(res.errorMessages, function(key, value) {
					$("#" + key).after("<span class='invalid-feedback'>" + value + "</span>")
				});
			}
		}
	})
}

personUtil.deletePerson = function(id) {
	$.ajax({
		url : '/adriaexo/deletePerson/'+id,
	    type: 'DELETE',
	    success: function() {
	    	personUtil.getAll();
	    }
	});
}