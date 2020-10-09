package person;

import java.time.LocalDate;

import Exception.PersonCharacteristicsException;
import education.Education;
import education.GradedEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private int height;
	private LocalDate dateOfBirth;
	private Education education;
	private Address address;

	public Person(String firstName, String middleName, String lastName, String gender, int height,
			LocalDate dateOfBirth, Education education, Address address) throws PersonCharacteristicsException{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.dateOfBirth = dateOfBirth;
		this.education = education;
		this.address = address;
	}

	private int getAge(LocalDate date) {
		int age = 2020 - date.getYear();
		return age;
	}

	@Override
	public String toString() {
		LocalDate dateToBeGraduate;
		String heOrShe = " ";
		String hisOrHer = " ";
		if (gender.equals("M")) {
			heOrShe = "He";
			hisOrHer = "His";
		} else if (gender.equals("F")) {
			heOrShe = "She";
			hisOrHer = "Her";
		}
		if (getAge(dateOfBirth) < 18) {
			dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 5, 05, 22);
			if (education instanceof PrimaryEducation) {
				return getInfoAboutUnderAgedPrimaryEducatedPeople(heOrShe, hisOrHer, dateToBeGraduate);
			} else if (education instanceof SecondaryEducation) {
				return getInfoAboutUnderAgedGradedPeople(heOrShe, hisOrHer, dateToBeGraduate);
			} else {
				return null;
			}
		} else {
			if (education instanceof PrimaryEducation) {
				dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 5, 05, 22);
				return getInfoAboutPrimaryEducatedPeople(heOrShe, hisOrHer);
			} else {
				if (education instanceof SecondaryEducation) {
					dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 5, 05, 22);
				} else {
					dateToBeGraduate = LocalDate.of(education.getEnrollmentDate().getYear() + 4, 06, 20);
				}
				try {
					return getInfoAboutGraduatedPeople(heOrShe, hisOrHer, dateToBeGraduate);
				} catch (PersonCharacteristicsException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return null;

	}

	private String getInfoAboutUnderAgedGradedPeople(String heOrShe, String hisOrHer, LocalDate dateToBeGraduate){
		return firstName + " " + middleName + " " + lastName + " is " + getAge(dateOfBirth) + " years old." + " "
				+ heOrShe + " was born in " + dateOfBirth.getYear() + ".\n" + firstName + " " + lastName
				+ " is uder-aged." + "\n" + heOrShe + " lives at: " + "\n" + address.toString() + "\n" + heOrShe
				+ " started " + education.getDegree() + " degree in " + education.getInstitutionName() + " on "
				+ education.getEnrollmentDate() + " and is supposed to graduate on " + dateToBeGraduate + ".\n";
	}

	private String getInfoAboutUnderAgedPrimaryEducatedPeople(String heOrShe, String hisOrHer,
			LocalDate dateToBeGraduate) {
		if (education.getGraduationDate().isBefore(LocalDate.now())) {
			return firstName + " " + middleName + " " + lastName + " is " + getAge(dateOfBirth) + " years old." + " "
					+ heOrShe + " was born in " + dateOfBirth.getYear() + ".\n" + firstName + " " + lastName
					+ " is uder-aged." + "\n" + heOrShe + " lives at: " + "\n" + address.toString() + "\n" + heOrShe
					+ " started " + education.getDegree() + " degree in " + education.getInstitutionName() + " on "
					+ education.getEnrollmentDate() + " and finished on " + education.getGraduationDate() + ".\n";
		} else {
			return firstName + " " + middleName + " " + lastName + " is " + getAge(dateOfBirth) + " years old." + " "
					+ heOrShe + " was born in " + dateOfBirth.getYear() + ".\n" + firstName + " " + lastName
					+ " is uder-aged." + "\n" + heOrShe + " lives at: " + "\n" + address.toString() + "\n" + heOrShe
					+ " started " + education.getDegree() + " degree in " + education.getInstitutionName() + " on "
					+ education.getEnrollmentDate() + " and is supposed to graduate on " + dateToBeGraduate + ".\n";

		}
	}

	private String getInfoAboutPrimaryEducatedPeople(String heOrShe, String hisOrHer) {
		return firstName + " " + middleName + " " + lastName + " is " + getAge(dateOfBirth) + " years old." + " "
				+ heOrShe + " was born in " + dateOfBirth.getYear() + ".\n" + heOrShe + " lives at: " + "\n"
				+ address.toString() + "\n" + heOrShe + " started " + education.getDegree() + " degree in "
				+ education.getInstitutionName() + " on " + education.getEnrollmentDate() + " and finished on "
				+ education.getGraduationDate() + ".\n";
	}

	private String getInfoAboutGraduatedPeople(String heOrShe, String hisOrHer, LocalDate dateToBeGraduate) throws PersonCharacteristicsException{
		GradedEducation d = (GradedEducation) education;
		if (education.getGraduationDate().isBefore(LocalDate.now())) {
			return firstName + " " + middleName + " " + lastName + " is " + getAge(dateOfBirth) + " years old." + " "
					+ heOrShe + " was born in " + dateOfBirth.getYear() + ".\n" + heOrShe + " lives at: " + "\n"
					+ address.toString() + "\n" + heOrShe + " started " + education.getDegree() + " degree in "
					+ education.getInstitutionName() + " on " + education.getEnrollmentDate() + " and finished on "
					+ education.getGraduationDate() + ". " + hisOrHer + " grade was " + d.getFinalGrade() + ".\n";
		} else {
			return firstName + " " + middleName + " " + lastName + " is " + getAge(dateOfBirth) + " years old." + " "
					+ heOrShe + " was born in " + dateOfBirth.getYear() + ".\n" + heOrShe + " lives at: " + "\n"
					+ address.toString() + "\n" + heOrShe + " started " + education.getDegree() + " degree in "
					+ education.getInstitutionName() + " on " + education.getEnrollmentDate()
					+ " and is supposed to graduate on " + dateToBeGraduate + ".\n";

		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public int getHeight() {
		return height;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Education getEducation() {
		return education;
	}

	public Address getAddress() {
		return address;
	}
	
}