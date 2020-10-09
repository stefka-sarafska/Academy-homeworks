package main;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import connection.MySqlSchoolData;
import data.Student;
import data.Teacher;

public class Task1_School {
	private static Scanner sp = new Scanner(System.in);

	public static void main(String[] args) {

		printMenu();
		int choice = Integer.parseInt(sp.nextLine());
		switch (choice) {
		case 1:
			MySqlSchoolData.insertTeacher();
			break;
		case 2:
			printTeacherByInputId();
			break;
		case 3:
			printTeachersWithSalaryBetweenTwoValues();
			break;
		case 4:
			MySqlSchoolData.insertStudent();
			break;
		case 5:
			printStudentByInputId();
			break;
		case 6:
			printStudentsAfterGivenEnrollmentDate();
			break;
		case 7:
			printDisciplinesByTeacherId();
			break;
		case 8:
			printTeachersByDisciplineName();
			break;

		default:
			System.out.println("You entered invalid choice!");
			break;
		}

	}

	private static void printMenu() {
		System.out.println("------------Menu-------------");
		System.out.println("1. Insert new teacher in DB");
		System.out.println("2. Get teacher by id");
		System.out.println("3. Get teachers with salary between x and y");
		System.out.println("4. Insert student in DB");
		System.out.println("5. Get student by id");
		System.out.println("6. Get students with enrollment date after date x");
		System.out.println("7. Get disciplines by teacher id");
		System.out.println("8. Get teachers by discipline name");
		System.out.println("------------------------------");
		System.out.println("Enter your choice [1-7]...");
	}

	private static void printTeachersByDisciplineName() {
		System.out.println("Enter discipline name for searching teachers that are teaching it...");
		String disciplineName = sp.nextLine();
		List<Teacher> teachers = MySqlSchoolData.getTeachersByDisciplineName(disciplineName);
		System.out.println("Teachers which teaching discipline " + disciplineName + " are: ");
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
		}
	}

	private static void printDisciplinesByTeacherId() {
		System.out.println("Enter teacher id for search disciplines he/she is teaching...");
		int id = Integer.parseInt(sp.nextLine());
		List<String> disciplines = MySqlSchoolData.getDisciplinesByTeacherId(id);
		Teacher teacher = MySqlSchoolData.getTeacher(id);
		System.out.println("Teacher " + teacher.getName() + " is teaching disciplines: ");
		for (String discipline : disciplines) {
			System.out.println(discipline);
		}
	}

	private static void printTeacherByInputId() {
		System.out.println("Enter teacher id for search..");
		int id = Integer.parseInt(sp.nextLine());
		Teacher teacher = MySqlSchoolData.getTeacher(id);
		System.out.println(teacher.toString());
	}

	private static void printStudentByInputId() {
		System.out.println("Enter student id for search..");
		int studentId = Integer.parseInt(sp.nextLine());
		Student student = MySqlSchoolData.getStudent(studentId);
		System.out.println(student.toString());
	}

	private static void printStudentsAfterGivenEnrollmentDate() {
		System.out.println("Enter enrollment date in format yyyy-mm-dd for search..");
		String[] currDate = sp.nextLine().split("-");
		LocalDate date = LocalDate.of(Integer.parseInt(currDate[0]), Integer.parseInt(currDate[1]),
				Integer.parseInt(currDate[2]));
		LinkedList<Student> students = MySqlSchoolData.getStudents(date);
		for (Student stu : students) {
			System.out.println(stu.toString());
		}
	}

	private static void printTeachersWithSalaryBetweenTwoValues() {
		System.out.println("Enter minsalary and maxsalary for search...");
		double minsalary = Double.parseDouble(sp.nextLine());
		double maxsalary = Double.parseDouble(sp.nextLine());
		LinkedList<Teacher> teachers = MySqlSchoolData.getTeachers(minsalary, maxsalary);
		for (Teacher teach : teachers) {
			System.out.println(teach.toString());
		}
	}
}
