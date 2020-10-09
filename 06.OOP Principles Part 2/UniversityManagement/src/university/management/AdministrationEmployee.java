package university.management;

public class AdministrationEmployee extends Employee {
	private String[] subjects;

	public AdministrationEmployee(String name, String phoneNumber,String[] subjects) {
		super(name, phoneNumber, 19);
		this.subjects = subjects;
	}
}
