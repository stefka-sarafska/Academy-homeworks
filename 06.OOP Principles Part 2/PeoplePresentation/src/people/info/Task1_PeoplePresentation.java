package people.info;

import java.util.Scanner;

public class Task1_PeoplePresentation {
	private static Person[] people = new Person[50];

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);

		int peopleCounter = 0;
		String line = sp.nextLine();
		String[] input = line.split(" ");
		String command = input[0];
		while (!command.equals("END")) {
			if (input.length == 5) {
				people[peopleCounter] = new Student(input[0], input[1], input[2], Integer.parseInt(input[3]),
						Integer.parseInt(input[4]));
				peopleCounter++;
			} else {
				people[peopleCounter] = new Worker(input[0], input[1], Double.parseDouble(input[2]),
						Integer.parseInt(input[3]));
				peopleCounter++;
			}

			line = sp.nextLine();
			input = line.split(" ");
			command = input[0];
		}
		sp.close();
		printPeople(people);
	}

	private static void printPeople(Person[] people) {
		for (Person p : people) {
			if (p != null) {
				if(p instanceof Student) {
					Student stu = (Student) p;
				System.out.printf(
						"First name: %s%nLast name: %s%nOccupation: Student%nFaculty number: %s%nHours per day: %.2f%n",
						stu.getFirstName(), stu.getLastName(), stu.getFacultyNumber(),
						stu.hoursPerDay(stu.getLectureCount(), stu.getExerciseCount()));
				System.out.println();
				} else if (p instanceof Worker) {
					Worker w = (Worker) p;
					System.out.printf(
							"First name: %s%nLast name: %s%nOccupation: Worker%nWeek salary: %.2f%nHours per day: %f%nSalary per hour: %.2f%n",
							w.firstName, w.getLastName(), w.getWeekSalary(), (double) (w.getWorkHoursPerDay()),
							w.getSalaryPerHour(w.getWeekSalary()));
					System.out.println();
				}
			}
		}
	}
}
