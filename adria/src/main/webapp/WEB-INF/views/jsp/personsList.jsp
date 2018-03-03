<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/core/css/home.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<spring:url value="/resources/core/js/home.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/core/js/jquery.min.js" var="jquery" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${jquery}"></script>
<title>Personne - Accueil</title>
<script>
	$(function() {
		$.ajax({
			method : "GET",
			url : "/adriaexo/persons",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(result) {
				var personsDataTable = $("#personsData");
				result.forEach(function(element) {
					personsDataTable.append("<tr><td style='display:none;'>" + element.id + "</td>\
							<td>" + element.completeName + "</td>\
							<td>" + element.phoneNum + "</td>\
							<td>" + element.email + "</td>\
							<td><button type='button' id='delete' class='btn btn-danger'>Supprimer</button></td></tr>");
				});
			}
		})
			// 		.done(function(data) {
			// 			for (i = 0; i < data.length; i++) {
			// 				console.log(data[i]);
			// 			}
			// 		})
			.fail(function() {
				console.log("Failed 4");
			})
	});
</script>

<script type="text/javascript">
	$(function() {
		/*  Submit form using Ajax */
		$('button[type=submit]').click(function(e) {

			console.log($("#completeName").val());
			var person = {
				"completeName" : $("#completeName").val(),
				"email" : $("#email").val(),
				"phoneNum" : $("#phoneNum").val()
			};

			console.log("person");
			console.log(person);
			//Prevent default submission of form
			e.preventDefault();

			//Remove all errors
			$('.invalid-feedback').remove();

			$.post({
				url : '/adriaexo/addPerson',
				data : person,
				success : function(res) {

					if (res.validated) {
						// 							//Set response
						// 							$('#resultContainer pre code').text(JSON.stringify(res.person));
						// 							$('#resultContainer').show();

					} else {
						//Set error messages
						$.each(res.errorMessages, function(key, value) {
							console.log(key + " " + value);
							// 								$('input[name=' + key + ']').after('<span class="error">' + value + '</span>');
							$("#" + key).after("<span class='invalid-feedback'>" + value + "</span>")
						});
					}
				}
			})
		});
	});
</script>
</head>
<body>
	<br />
	<div class="container">
		<div class="container">
			<form:form id="personForm" method="POST" action="#" modelAttribute="person">

				<form:input type="hidden" path="id" id="id" />

				<div class="form-group">
					<form:label for="completeName" path="completeName">Nom complet</form:label>
					<form:input type="text" path="completeName"
						class="form-control is-invalid" id="completeName"
						placeholder="Entez votre nom complet" />
					<form:errors path="completeName" cssClass="invalid-feedback"
						element="div" />
				</div>

				<div class="form-group">
					<form:label path="phoneNum" for="phoneNum">Numéro de téléphone</form:label>
					<form:input type="text" path="phoneNum"
						class="form-control is-invalid" id="phoneNum"
						placeholder="Entez votre numéro de téléphone" />
					<form:errors path="phoneNum" cssClass="invalid-feedback"
						element="div" />
				</div>

				<div class="form-group">
					<form:label path="email" for="email">Email</form:label>
					<form:input type="email" path="email"
						class="form-control is-invalid" id="email"
						placeholder="Entez votre email" />
					<form:errors path="email" cssClass="invalid-feedback" element="div" />
				</div>

				<button type="submit" class="btn btn-primary">Ajouter</button>

			</form:form>
		</div>

		<hr>

		<div class="container">
			<div class="personsList">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Nom complet</th>
							<th scope="col">Numéro de téléphone</th>
							<th scope="col">Email</th>
							<th scope="col">#</th>
						</tr>
					</thead>
					<tbody id="personsData">
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>