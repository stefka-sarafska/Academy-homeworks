package person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Exception.PersonCharacteristicsException;
import education.Education;
import education.GradedEducation;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;

public class Task3_PersonCharacteristics {
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
	private static Person[] people;

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = Integer.parseInt(sp.nextLine());

		people = new Person[n];

		for (int i = 0; i < n; i++) {
			String line = sp.nextLine();
			String[] input = line.split(";");

			try {
				insertPersonInPeopleFromInput(input, i);
				System.out.println(people[i].toString());
			} catch (PersonCharacteristicsException e) {
				System.out.println("!!!" + e.getMessage() + "!!!");
				System.out.println();
			}
		}
		sp.close();
		// printPeopleInfo(people);
	}

	private static void insertPersonInPeopleFromInput(String[] input, int i) throws PersonCharacteristicsException {
		Person person = createPerson(input);
		validatePersonCharacteristics(person);
		people[i] = person;
	}

	private static Person createPerson(String[] input) throws PersonCharacteristicsException {
		String firstName = input[0];
		String middleName = input[1];
		String lastName = input[2];
		String gender = input[3];
		LocalDate birthDate = LocalDate.parse(input[4], formatter);
		int height = Integer.parseInt(input[5]);
		String country = input[6];
		String city = input[7];
		String municipality = input[8];
		String postalCode = input[9];
		String street = input[10];
		int number = Integer.parseInt(input[11]);
		int floor = Integer.parseInt(input[12]);
		int apartmentNo = Integer.parseInt(input[13]);
		String codeForEducation = input[14];
		String institutionName = input[15];
		LocalDate enrollmentDate = LocalDate.parse(input[16], formatter);
		LocalDate graduationDate = LocalDate.parse(input[17], formatter);
		float finalGrade = 0;
		boolean graduated = false;
		Education education;

		if (graduationDate.isBefore(LocalDate.now())) {
			finalGrade = Float.parseFloat(input[18]);
			graduated = true;
		} else if (graduationDate.isAfter(LocalDate.now()) && !"primary".equals(codeForEducation)) {
			finalGrade = 0;
			graduated = false;
		}

		Address address = new Address(country, city, municipality, postalCode, street, number, floor, apartmentNo);
		if ("P".equals(codeForEducation)) {
			education = new PrimaryEducation(graduated, enrollmentDate, graduationDate, institutionName);
		} else if ("S".equals(codeForEducation)) {
			education = new SecondaryEducation(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
		} else if ("B".equals(codeForEducation)) {
			education = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
			((HigherEducation) education).setDegree("bachelor");
		} else if ("M".equals(codeForEducation)) {
			education = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
			((HigherEducation) education).setDegree("master");
		} else if ("D".equals(codeForEducation)) {
			education = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
			((HigherEducation) education).setDegree("doctor");
		} else {
			throw new PersonCharacteristicsException("Unrecognized education code.");
		}
		return new Person(firstName, middleName, lastName, gender, height, birthDate, education, address);
	}

	private static void validatePersonCharacteristics(Person person) throws PersonCharacteristicsException {
		Education personEducation = person.getEducation();
		if (personEducation.getEnrollmentDate().isAfter(personEducation.getGraduationDate())) {
			throw new PersonCharacteristicsException("Graduation date is expected to be after enrollment date.");
		}
		if (person.getDateOfBirth().isBefore(LocalDate.of(1900, 1, 1))
				|| person.getDateOfBirth().isAfter(LocalDate.now())) {
			throw new PersonCharacteristicsException(
					"Date of birth is expected to be after 01.01.1900 and before now.");
		}
		if (person.getFirstName().isEmpty()) {
			throw new PersonCharacteristicsException("Expected non-empty first name.");
		}
		if (person.getLastName().isEmpty()) {
			throw new PersonCharacteristicsException("Expected non-empty last name.");
		}
		if (personEducation.getInstitutionName().isEmpty()) {
			throw new PersonCharacteristicsException("Expected non-empty institution name.");
		}
		if (person.getHeight() < 40 || person.getHeight() > 300) {
			throw new PersonCharacteristicsException("Expected height is between 40 and 300 cm.");
		}
		if (!person.getGender().equals("M") && !person.getGender().equals("F")) {
			throw new PersonCharacteristicsException("Expected M or F for gender.");
		}
		if (personEducation.gotGraduated()) {
			if (personEducation.getGraduationDate().isAfter(LocalDate.now())) {
				throw new PersonCharacteristicsException("Graduation date is expected to be a date in the past.");
			}
		}

		if (personEducation instanceof GradedEducation) {
			float finalGrade = ((GradedEducation) personEducation).getFinalGrade();
			if (finalGrade < 2 || finalGrade > 6) {
				throw new PersonCharacteristicsException("Graduation grade is expected to be between 2 and 6.");
			}
		}
	}
}
