package data;

public class Teacher {
	private String name;
	private String email;
	private double salary;

	public Teacher(String name, String email, double salary) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Teacher: " + name + "\nEmail=" + email + "\nSalary=" + salary;
	}

	public String getName() {
		return name;
	}

}
