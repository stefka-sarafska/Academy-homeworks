package person.characteristics;

import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private String gender;
	private int height;
	private LocalDate dateOfBirth;
	private SecondaryEducation education;

	public Person(String firstName, String lastName, String gender, int height, LocalDate dateOfBirth,
			SecondaryEducation education) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.dateOfBirth = dateOfBirth;
		this.education = education;
	}

	private int getAge(LocalDate date) {
		int age = 2016 - date.getYear();
		return age;
	}

	public void showInfoAboutPerson() {
		if (gender.equals("M")) {
			System.out.printf("%s %s is %d years old. He was born in %d. He started %s on %s and ", firstName, lastName,
					getAge(dateOfBirth), dateOfBirth.getYear(), education.getInstitutionName(),
					education.getEnrollmentDate().toString());
			if (getAge(dateOfBirth) >= 18 && education.isGraduated() == true) {
				System.out.printf("finished on %s with a grade of %.2f.", education.getGraduationDate().toString(),
						education.getFinalGrade());

			} else {
				LocalDate dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 5, 05, 22);
				System.out.printf("is supposed to graduate on %s. %s %s is under-aged.", dateToBeGraduate.toString(),
						firstName, lastName);

			}
			System.out.println();
		} else if (gender.equals("F")) {
			System.out.printf("%s %s is %d years old. She was born in %d. She started %s on %s and ", firstName,
					lastName, getAge(dateOfBirth), dateOfBirth.getYear(), education.getInstitutionName(),
					education.getEnrollmentDate().toString());
			if (getAge(dateOfBirth) >= 18 && education.isGraduated() == true) {
				System.out.printf("finished on %s with a grade of %.2f.", education.getGraduationDate().toString(),
						education.getFinalGrade());

			} else {
				LocalDate dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 5, 05, 22);
				System.out.printf("is supposed to graduate on %s. %s %s is under-aged.", dateToBeGraduate.toString(),
						firstName, lastName);
				System.out.println();
			}
		}
	}

}
