package university.management;

public class Student extends Person {
	private String facultyNumber;
	private String[] subjects;

	public Student(String name, String phoneNumber, String facultyNumber, String[] subjects) {
		super(name, phoneNumber);
		this.facultyNumber = facultyNumber;
		this.subjects = subjects;
	}
}
