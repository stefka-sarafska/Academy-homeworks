package university.management;

public abstract class Person {
	private String name;
	private String phoneNumber;
	private int tolerance = 20;

	public Person(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void changeTolerance(int tolerance) {
		this.tolerance += tolerance;
		if (this.tolerance <= 0) {
			System.out.println(this.getName() + " is not happy");
			System.exit(1);
		}
	}

	public int getTolerance() {

		return this.tolerance;

	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
