package swift.classes;

import java.util.Scanner;

public class Employee {
	String name;
	double salary;
	String position;
	String department;
	short age;
	String email;

	public Employee(String name, double salary, String position, String department, short age, String email) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.age = age;
		this.email = email;
	}

	public Employee(String name, double salary, String position, String department) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
	}

	Employee(double salary) {
		this.salary = salary;
	}

	public void printTopThreeHighestSalaries(Employee[] emp) {
		Employee firstEmployee = new Employee(Double.MIN_VALUE);
		Employee thirdEmployee = new Employee(Double.MIN_VALUE);
		Employee secondEmployee = new Employee(Double.MIN_VALUE);

		for (Employee e : emp) {
			if (e.getSalary() > firstEmployee.getSalary()) {
				Employee temp = firstEmployee;
				firstEmployee = e;
				e = temp;
			}
			if (e.getSalary() > secondEmployee.getSalary()) {
				Employee temp = secondEmployee;
				secondEmployee = e;
				e = temp;
			}
			if (e.getSalary() > thirdEmployee.getSalary()) {
				thirdEmployee = e;
			}
		}

		Employee[] topEmployee = new Employee[] { firstEmployee, secondEmployee, thirdEmployee };
		for (Employee e : topEmployee) {
			if (e.getName() != null) {
				System.out.printf("%s,%s, %s%s", e.getName(), e.getPosition(), e.getDepartment(),
						(e.getEmail() != null ? ", " + e.getEmail() : "") + "\n");
			}
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		sp.nextLine();
		Employee[] employees = new Employee[n];
		for (int i = 0; i < n; i++) {
			String line = sp.nextLine();
			String[] input = line.split(", ");
			String name = input[0];
			double salary = Double.parseDouble(input[1]);
			String position = input[2];
			String department = input[3];
			if (input.length > 4) {
				short age = Short.parseShort(input[4]);
				String email = input[5];
				employees[i] = new Employee(name, salary, position, department, age, email);
			} else {
				employees[i] = new Employee(name, salary, position, department);
			}
		}
		employees[0].printTopThreeHighestSalaries(employees);
	}
}
