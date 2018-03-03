package com.younesnaja.adria.exo.DAO;

import java.io.IOException;
import java.util.List;

import com.younesnaja.adria.exo.Model.Person;

public interface PersonDAO {
	public void addPerson(Person person) throws IOException;
	public Person getPerson(Person person);
	public List<Person> getAllPersons();
	void writeToFile(String person);
}