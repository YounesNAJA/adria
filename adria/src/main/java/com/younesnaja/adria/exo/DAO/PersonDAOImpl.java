package com.younesnaja.adria.exo.DAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.younesnaja.adria.exo.Model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	// private static String personsFileLocation = "resources/Persons.txt";
	// private static Gson gson = new Gson();

	private String fileName = "/home/younes/eclipse-workspace/adria/src/main/webapp/resources/Persons.txt";

	@Override
	public void addPerson(Person person) {
		File file = new File(fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(fileName, true);
			fw.write(person.toString() + "\n");
			fw.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	@Override
	public Person getPerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAllPersons() {
		Person p1 = new Person(1, "Younes NAJA", "0659703347", "naja.younes@gmail.com");
		Person p2 = new Person(2, "Younes NAJA", "0659703347", "naja.younes@gmail.com");
		Person p3 = new Person(3, "Younes NAJA", "0659703347", "naja.younes@gmail.com");

		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);

		return persons;
	}

	public String readFromFile() {

		StringBuilder result = new StringBuilder("");

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	// Save to file Utility
	public void writeToFile(String person) {
		ClassLoader classLoader = getClass().getClassLoader();
		// File file = new File(classLoader.getResource("Persons.txt").getFile());

		String personsFileLocation = classLoader.getResource(fileName).getFile();

		File personsFile = new File(personsFileLocation);
		if (!personsFile.exists()) {
			try {
				File directory = new File(personsFile.getParent());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				personsFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Excepton Occured: " + e.toString());
			}
		}

		try {
			// Convenience class for writing character files
			FileWriter personsWriter;
			personsWriter = new FileWriter(personsFile.getAbsoluteFile(), true);

			// Writes text to a character-output stream
			BufferedWriter bufferWriter = new BufferedWriter(personsWriter);
			bufferWriter.write(person.toString());
			bufferWriter.close();

			System.out
					.println("Company data saved at file location: " + personsFileLocation + " Data: " + person + "\n");
		} catch (IOException e) {
			System.out.println("Hmm.. Got an error while saving Company data to file " + e.toString());
		}
	}

}
