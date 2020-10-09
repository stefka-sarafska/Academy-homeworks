package person.characteristics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
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
			String lastName = input[1];
			String gender = input[2];
			int height = Integer.parseInt(input[3]);
			LocalDate birthDate = LocalDate.parse(input[4], formatter);
			String institutionName = input[5];
			LocalDate enrollmentDate = LocalDate.parse(input[6], formatter);
			LocalDate graduationDate = LocalDate.parse(input[7], formatter);
			if (input.length > 8) {
				double finalGrade = Double.parseDouble(input[8]);
				SecondaryEducation educations = new SecondaryEducation(institutionName, enrollmentDate, graduationDate,
						finalGrade);
				people[i] = new Person(firstName, lastName, gender, height, birthDate, educations);
			} else {
				SecondaryEducation educations = new SecondaryEducation(institutionName, enrollmentDate, graduationDate,
						0);
				people[i] = new Person(firstName, lastName, gender, height, birthDate, educations);
			}

		}
		sp.close();
		printPeopleInfo(people);

	}

	private static void printPeopleInfo(Person[] people) {
		for (Person p : people) {
			p.showInfoAboutPerson();
		}
	}
}
