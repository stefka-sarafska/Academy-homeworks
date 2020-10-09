package data;

import java.time.LocalDate;

public class Student {
	private String name;
	private LocalDate enrollment_date;

	public Student(String name, LocalDate enrollment_date) {
		this.name = name;
		this.enrollment_date = enrollment_date;
	}

	@Override
	public String toString() {
		return "Student: " + name + "\nEnrollment date: " + enrollment_date+"\n";
	}
	

}
