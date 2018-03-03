package com.younesnaja.adria.exo.Service;

import java.util.List;

import com.younesnaja.adria.exo.Model.Person;

public interface PersonService {

	List<Person> getAllPersons();

	void add(Person person);
	
	void writeToFile(Person person);

}
