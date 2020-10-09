package people.info;

public abstract class Person {
	protected String firstName;
	protected String lastName;

	public Person(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public void setFirstName(String firstName) {
		if ( firstName != null && firstName.length() >= 2 && firstName.length() <= 30) {
			this.firstName = firstName;
		} else {
			System.out.println("Expected length for first name is between 2 and 30 symbols.");
			System.exit(1);
		}
		if (isNameWithLatinLetters(firstName)) {
			this.firstName = firstName;
		} else {
			System.out.println("Expected only Latin letters in first name.");
			System.exit(1);
		}
		if (isFirstLetterUpper(firstName)) {
			this.firstName = firstName;
		} else {
			System.out.println("Expected upper case letter at first position of first name.");
			System.exit(1);
		}
	}

	public void setLastName(String lastName) {
		if (lastName.length() >= 2 && lastName.length() <= 30 && lastName != null) {
			this.lastName = lastName;
		} else {
			System.out.println("Expected length for last name is between 2 and 30 symbols.");
			System.exit(1);
		}
		if (isNameWithLatinLetters(lastName) == true) {
			this.lastName = lastName;
		} else {
			System.out.println("Expected only Latin letters in last name.");
			System.exit(1);
		}
		if (isFirstLetterUpper(lastName) == true) {
			this.lastName = lastName;
		} else {
			System.out.println("Expected upper case letter at first position of last name.");
			System.exit(1);
		}
	}

	private boolean isNameWithLatinLetters(String name) {
		return (name != null&& !name.isEmpty() && (name.matches("^[a-zA-Z]*$")));
	}

	private boolean isFirstLetterUpper(String name) {
		if (Character.isUpperCase(name.charAt(0))) {
			return true;
		} else {
			return false;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
