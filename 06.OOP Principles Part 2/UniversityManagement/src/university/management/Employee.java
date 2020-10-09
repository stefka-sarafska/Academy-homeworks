package university.management;

public class Employee extends Person {
	private int salaryPerHour;
	

	public Employee(String name, String phoneNumber, int salaryPerHour) {
		super(name, phoneNumber);
		this.salaryPerHour=salaryPerHour;
	}


	public int getSalaryPerHour() {
		return salaryPerHour;
	}


	public void setSalaryPerHour(int salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}
	
	

}
