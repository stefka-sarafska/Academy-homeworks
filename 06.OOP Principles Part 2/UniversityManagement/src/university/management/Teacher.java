package university.management;

public class Teacher extends Employee{
private String[] subjects;
public Teacher(String name,String phoneNumber,String[] subjects) {
	super(name,phoneNumber,25);
	this.subjects=subjects;
}
}
