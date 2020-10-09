package person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import education.Education;
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

			Address address = new Address(country, city, municipality, postalCode, street, number, floor, apartmentNo);
			if (graduationDate.isBefore(LocalDate.now())) {
				float finalGrade = Float.parseFloat(input[18]);
				boolean graduated = true;
				if ("P".equals(codeForEducation)) {
					PrimaryEducation p = new PrimaryEducation(graduated, enrollmentDate, graduationDate,
							institutionName);
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, p, address);
				} else if ("S".equals(codeForEducation)) {
					SecondaryEducation s = new SecondaryEducation(graduated, enrollmentDate, graduationDate,
							institutionName, finalGrade);
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, s, address);
				} else if ("B".equals(codeForEducation)) {
					HigherEducation h = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName,
							finalGrade);
					h.setDegree("bachelor");
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, h, address);
				} else if ("M".equals(codeForEducation)) {
					HigherEducation h = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName,
							finalGrade);
					h.setDegree("master");
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, h, address);
				} else if ("D".equals(codeForEducation)) {
					HigherEducation h = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName,
							finalGrade);
					h.setDegree("doctor");
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, h, address);
				}
			} else if (graduationDate.isAfter(LocalDate.now()) && !"primary".equals(codeForEducation)) {
				float finalGrade = 0;
				boolean graduated = false;
				if ("P".equals(codeForEducation)) {
					PrimaryEducation p = new PrimaryEducation(graduated, enrollmentDate, graduationDate,
							institutionName);
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, p, address);
				} else if ("S".equals(codeForEducation)) {
					SecondaryEducation s = new SecondaryEducation(graduated, enrollmentDate, graduationDate,
							institutionName, finalGrade);
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, s, address);
				} else if ("B".equals(codeForEducation)) {
					HigherEducation h = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName,
							finalGrade);
					h.setDegree("bachelor");
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, h, address);
				} else if ("M".equals(codeForEducation)) {
					HigherEducation h = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName,
							finalGrade);
					h.setDegree("master");
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, h, address);
				} else if ("D".equals(codeForEducation)) {
					HigherEducation h = new HigherEducation(graduated, enrollmentDate, graduationDate, institutionName,
							finalGrade);
					h.setDegree("doctor");
					people[i] = new Person(firstName, middleName, lastName, gender, height, birthDate, h, address);
				}
			}

			System.out.println(people[i].toString());

		}
		// printPeopleInfo(people);
	}

	private static void printPeopleInfo(Person[] people) {
		for (Person p : people) {
			if (p != null) {
				System.out.println(p);
				;
			}
		}
	}
}
