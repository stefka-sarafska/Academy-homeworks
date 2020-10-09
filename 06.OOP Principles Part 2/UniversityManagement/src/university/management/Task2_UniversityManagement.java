package university.management;

import java.util.Scanner;

public class Task2_UniversityManagement {
	private static Person[] people = new Person[500];
	private static int universityCapital = 500;
	private static Person[] workingPeople=new Person[500];

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);

		String line = sp.nextLine();
		String[] input = line.split(" ");
		String command = input[0];
		int countPeople = 0;
		int countForWorkingPeople=0;

		while (!"END".equals(command)) {
			if ("NEW".equals(command)) {
				if ("MAINT".equals(input[1])) {
					people[countPeople] = new MaintenanceEmployee(input[2], input[3]);
					countPeople++;
				} else if ("ADMIN".equals(input[1])) {
					people[countPeople] = new AdministrationEmployee(input[2], input[3],
							countOfSubjects(input, 4));
					countPeople++;
				} else if ("TEACH".equals(input[1])) {
					people[countPeople] = new Teacher(input[2], input[3], countOfSubjects(input, 4));
					countPeople++;
				} else if ("STUD".equals(input[1])) {
					people[countPeople] = new Student(input[2], input[3], input[4],
							countOfSubjects(input, 5));
				}

			} else if ("WORK".equals(command)) {

				Person person = searchPersonByName(input[1]);
				if(person!=null) {
					workingPeople[countForWorkingPeople]=person;
					countForWorkingPeople++;
				}
				
				if (person instanceof Student) {
					Student s = (Student) person;
					person.changeTolerance(2);
					changeMaintenenceTolerance(-1);
					if (s.getTolerance() >= 50) {
						changeUniversityCapital(10);
					}

				} else if (person instanceof AdministrationEmployee) {
					AdministrationEmployee a = (AdministrationEmployee) person;
					changeStudentsTolerance(3);
					changeTeachersTolerance(3);
					changeMaintenenceTolerance(1);
					changeUniversityCapital(a.getSalaryPerHour());
				} else if (person instanceof MaintenanceEmployee) {
					MaintenanceEmployee m = (MaintenanceEmployee) person;
					changeEveryoneTolerance(2);
					changeUniversityCapital(m.getSalaryPerHour());
				} else if (person instanceof Teacher) {
					Teacher t = (Teacher) person;
					changeStudentsTolerance(3);
					changeMaintenenceTolerance(-3);
					changeAdministrationTolerance(-1);
					changeUniversityCapital(t.getSalaryPerHour());
				}
				
			} else if ("IDLE".equals(command)) {
				changeEveryoneTolerance(-5);
			}

			line = sp.nextLine();
			input = line.split(" ");
			command = input[0];
			if(command.equals("END")) {
				printWorkingPeople(workingPeople);
			}

		}

	}
	private static void printWorkingPeople(Person[] workingPeople) {
		for(Person p:workingPeople) {
			if(p!=null) {
				System.out.print(p.getName()+" "+p.getTolerance()+"\n");
			}
		}
	}

	private static void changeUniversityCapital(int amount) {
		universityCapital -= amount;
		if (universityCapital <= 0) {
			System.out.println("Bankrupcy");
			System.exit(1);
		}
	}

	private static void changeMaintenenceTolerance(int tolerance) {
		for (Person person : people) {
			if (person instanceof MaintenanceEmployee) {
				person.changeTolerance(tolerance);
			}
		}
	}

	private static void changeStudentsTolerance(int tolerance) {
		for (Person person : people) {
			if (person instanceof Student) {
				person.changeTolerance(tolerance);
			}
		}
	}

	private static void changeTeachersTolerance(int tolerance) {
		for (Person person : people) {
			if (person instanceof Teacher) {
				person.changeTolerance(tolerance);
			}
		}
	}

	private static void changeAdministrationTolerance(int tolerance) {
		for (Person person : people) {
			if (person instanceof AdministrationEmployee) {
				person.changeTolerance(tolerance);
			}
		}
	}

	private static void changeEveryoneTolerance(int tolerance) {
		for (Person person : people) {
			if (person != null) {
				person.changeTolerance(tolerance);
			}
		}
	}

	private static String[] countOfSubjects(String[] input, int propertiesForPerson) {
		int lenghtOfArray = input.length - propertiesForPerson;
		String[] subjects = new String[lenghtOfArray];
		for (int i = 0; i < subjects.length; i++) {
			subjects[i] = input[i];
		}
		return subjects;
	}

	private static Person searchPersonByName(String name) {
		for (Person p : people) {
			if (p != null && name.equals(p.getName())) {
				return p;
			}
		}
		return null;
	}

}
