package com.younesnaja.adria.exo.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.younesnaja.adria.exo.DAO.PersonDAO;
import com.younesnaja.adria.exo.Model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	public List<Person> getAllPersons() {
		return personDAO.getAllPersons();
	}

	@Override
	public void add(Person person) {
		try {
			personDAO.addPerson(person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void writeToFile(Person person) {
		personDAO.writeToFile(person.toString());
	}

}
