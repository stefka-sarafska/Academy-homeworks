package person;

import java.time.LocalDate;

import education.Education;
import education.GradedEducation;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;

public class Person {
	private String firstName;
	private String lastName;
	private String gender;
	private int height;
	private LocalDate dateOfBirth;
	private Education education;

	public Person(String firstName, String lastName, String gender, int height, LocalDate dateOfBirth,
			Education education) {
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
			System.out.printf("%s %s is %d years old. He was born in %d. He started %s degree in %s on %s and ",
					firstName, lastName, getAge(dateOfBirth), dateOfBirth.getYear(), education.getDegree(),
					education.getInstitutionName(), education.getEnrollmentDate().toString());

			if (education.isGraduated() == true) {
				GradedEducation g = (GradedEducation) education;
				System.out.printf("finished on %s with a grade of %.2f.", education.getGraduationDate().toString(),
						g.getFinalGrade());

			} else {
				if (education instanceof HigherEducation) {
					LocalDate dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 4, 06, 20);
					System.out.printf("is supposed to graduate on %s.", dateToBeGraduate.toString());
				} else {
					LocalDate dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 5, 05, 22);
					System.out.printf("is supposed to graduate on %s.", dateToBeGraduate.toString());

				}
			}
			if (getAge(dateOfBirth) < 18) {
				System.out.printf("%s %s is under-aged.", firstName, lastName);
			}
			System.out.println();
		} else if (gender.equals("F")) {
			System.out.printf("%s %s is %d years old. She was born in %d. She started %s degree on %s and ", firstName,
					lastName, getAge(dateOfBirth), dateOfBirth.getYear(), education.getDegree(),
					education.getInstitutionName(), education.getEnrollmentDate().toString());
			
			if (education.isGraduated() == true) {
				GradedEducation g = (GradedEducation) education;
				System.out.printf("finished on %s with a grade of %.2f.", education.getGraduationDate().toString(),
						g.getFinalGrade());

			} else {
				if (education instanceof HigherEducation) {
					LocalDate dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 4, 06, 20);
					System.out.printf("is supposed to graduate on %s.", dateToBeGraduate.toString());

				} else {
					LocalDate dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 5, 05, 22);
					System.out.printf("is supposed to graduate on %s.", dateToBeGraduate.toString());

				}
			}
			if (getAge(dateOfBirth) < 18) {
				System.out.printf("%s %s is under-aged.", firstName, lastName);
			}
			System.out.println();
		}
	}
}