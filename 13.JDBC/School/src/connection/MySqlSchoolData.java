package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import data.Student;
import data.Teacher;

public class MySqlSchoolData {
	private static Scanner sp = new Scanner(System.in);

	public static List<Teacher> getTeachersByDisciplineName(String disciplineName) {
		List<Teacher> teachers = new LinkedList<Teacher>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from teachers where id=?")) {
			List<Integer> teachersIds = getTeacherIdByDisciplineId(disciplineName);
			for (Integer teacherId : teachersIds) {
				ps.setInt(1, teacherId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Teacher teacher = new Teacher(rs.getString(2), rs.getString(3), rs.getDouble(4));
					teachers.add(teacher);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;

	}

	private static List<Integer> getTeacherIdByDisciplineId(String disciplineName) {
		int disciplineId = getDisciplineIdByName(disciplineName);
		List<Integer> teachersIds = new LinkedList<Integer>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con
						.prepareStatement("select teacher_id from disciplines_taught where discipline_id=?")) {
			ps.setInt(1, disciplineId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				teachersIds.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachersIds;
	}

	private static int getDisciplineIdByName(String disciplineName) {
		int disciplineId = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select id from disciplines where name=?")) {
			ps.setString(1, disciplineName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				disciplineId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disciplineId;
	}

	public static List<String> getDisciplinesByTeacherId(int id) {
		List<String> disciplines = new LinkedList<String>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from disciplines where id=?")) {

			List<Integer> disciplinesIds = getDicsciplinesByTeacherId(id);
			for (Integer disciplineId : disciplinesIds) {
				ps.setInt(1, disciplineId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					disciplines.add(rs.getString(2));
				}
			}
		} catch (SQLException e) {
			System.out.println("?");
			e.printStackTrace();
		}
		return disciplines;
	}

	private static List<Integer> getDicsciplinesByTeacherId(int teacherId) {
		List<Integer> disciplinesIds = new LinkedList<Integer>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from disciplines_taught where teacher_id=?")) {
			ps.setInt(1, teacherId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				disciplinesIds.add(rs.getInt(2));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return disciplinesIds;
	}

	public static void insertStudent() {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con
						.prepareStatement("insert into students(name,enrollment_date,address_id) values(?,?,?)")) {
			System.out.println("Student name: ");
			String name = sp.nextLine();
			System.out.println("Student enrollment date in format yyyy-mm-dd: ");
			String date = sp.nextLine();
			System.out.println("Enter address id: ");
			int addressId = Integer.parseInt(sp.nextLine());
			ps.setString(1, name);
			ps.setString(2, date);
			while (searchAddressIdInDB(addressId) == 0) {
				System.out
						.println("Address with " + addressId + " id does not exist, please enter correct address id: ");
				addressId = Integer.parseInt(sp.nextLine());
			}
			ps.setInt(3, addressId);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Can not insert into table teachers, because " + e.getMessage());
		}
	}

	public static Student getStudent(int id) {
		Student student = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from students where id=?")) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getString(2), LocalDate.parse(rs.getString(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return student;
	}

	public static LinkedList<Student> getStudents(LocalDate date) {
		LinkedList<Student> students = new LinkedList<Student>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from students where enrollment_date > ?")) {
			ps.setString(1, date.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student currentStudent = new Student(rs.getString(2), LocalDate.parse(rs.getString(3)));
				students.add(currentStudent);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return students;
	}

	public static void insertTeacher() {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con
						.prepareStatement("insert into teachers(name,email,salary,address_id) values(?,?,?,?)")) {
			System.out.println("Teacher name: ");
			String name = sp.nextLine();
			System.out.println("Teacher email: ");
			String email = sp.nextLine();
			System.out.println("Teacher salary: ");
			double salary = Double.parseDouble(sp.nextLine());
			System.out.println("Enter address id: ");
			int addressId = Integer.parseInt(sp.nextLine());
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setDouble(3, salary);
			while (searchAddressIdInDB(addressId) == 0) {
				System.out
						.println("Address with " + addressId + " id does not exist, please enter correct address id: ");
				addressId = Integer.parseInt(sp.nextLine());
			}
			ps.setInt(4, addressId);

			ps.execute();
		} catch (SQLException e) {
			System.out.println("Can not insert into table teachers, because " + e.getMessage());
		}
	}

	public static LinkedList<Teacher> getTeachers(double minSalary, double maxSalary) {
		LinkedList<Teacher> teachers = new LinkedList<Teacher>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from teachers where salary between ? and ?")) {
			ps.setDouble(1, minSalary);
			ps.setDouble(2, maxSalary);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher(rs.getString(2), rs.getString(3), rs.getDouble(4));
				teachers.add(teacher);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return teachers;
	}

	public static Teacher getTeacher(int id) {
		Teacher teacher = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from teachers where id=?")) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				teacher = new Teacher(rs.getString(2), rs.getString(3), rs.getDouble(4));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return teacher;
	}

	private static int searchAddressIdInDB(int searchedId) {
		int id = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from addresses where id=?")) {
			ps.setInt(1, searchedId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}

}
