package com.younesnaja.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.younesnaja.adria.exo.Model.Person;
import com.younesnaja.adria.exo.Model.PersonJSON;
import com.younesnaja.adria.exo.Service.PersonService;

@RestController
public class PersonREST {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons = personService.getAllPersons();

		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public PersonJSON addPerson(@Valid Person person, BindingResult bindingResult) {
		PersonJSON response = new PersonJSON();
		
        if (bindingResult.hasErrors()) {
        	// Get error message
			Map<String, String> errors = bindingResult.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

			response.setValidated(false);
			response.setErrorMessages(errors);
        }  else {
        	personService.add(person);
			System.out.println(person + " Person Saved");
			response.setValidated(true);
			response.setPerson(person);
		}

        return response;
    }

//	@PostMapping(value = "/addPerson", produces = { MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public PersonJSON addPerson(@ModelAttribute @Valid Person person, BindingResult result) {
//		System.out.println("HEEEERE addPerson");
//		PersonJSON respone = new PersonJSON();
//
//		if (result.hasErrors()) {
//
//			// Get error message
//			Map<String, String> errors = result.getFieldErrors().stream()
//					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//
//			respone.setValidated(false);
//			respone.setErrorMessages(errors);
//		} else {
//			// Implement business logic to save employee into database
//			// ..
//			System.out.println(person + " Person Saved");
//			respone.setValidated(true);
//			respone.setPerson(person);
//		}
//		return respone;
//	}
}
