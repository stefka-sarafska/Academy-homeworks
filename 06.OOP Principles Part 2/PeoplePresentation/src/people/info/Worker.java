package people.info;

public class Worker extends Person {
	private double weekSalary;
	private int workHoursPerDay;
	private final int workDays = 5;

	public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
		super(firstName, lastName);
		this.weekSalary = weekSalary;
		this.workHoursPerDay = workHoursPerDay;
	}

	public double getSalaryPerHour(double salary) {
		double salaryPerDay = salary / workDays * this.workHoursPerDay;
		return salaryPerDay;
	}

	public void setWeekSalary(double weekSalary) {
		if (weekSalary >= 0) {
			this.weekSalary = weekSalary;
		} else {
			System.out.println("Expected positive number for week salary.");
			System.exit(1);
		}
	}

	public void setWorkHoursPerDay(int workHoursPerDay) {
		if (workHoursPerDay >= 0) {
			this.workHoursPerDay = workHoursPerDay;
		} else {
			System.out.println("Expected positive number for wokr hours per day.");
			System.exit(1);
		}
	}

	public double getWeekSalary() {
		return weekSalary;
	}

	public int getWorkHoursPerDay() {
		return workHoursPerDay;
	}

}
