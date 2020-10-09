import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Task0_Sakila {
	private static Scanner sp = new Scanner(System.in);

	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		System.out.println("---------Menu--------");
		System.out.println("1. Insert new actor in DB");
		System.out.println("2. Add existing actor to film");
		System.out.println("3. Add new actor and associates it to existing film");
		int choice = Integer.parseInt(sp.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter actor first name: ");
			String firstName = sp.nextLine();
			System.out.println("Enter actor last name: ");
			String lastName = sp.nextLine();
			addActorsInTableActor(firstName, lastName);
			break;
		case 2:
			System.out.println("Enter existing actor id and film id to add actor with film");
			System.out.println("Actor id ");
			int actor_id = sp.nextInt();
			System.out.println("Film id: ");
			int film_id = sp.nextInt();
			addExistingActorToFilm(actor_id, film_id);

			break;
		case 3:
			System.out.println("Enter actor first name: ");
			String fName=sp.nextLine();
			System.out.println("Enter actor last name: ");
			String lName=sp.nextLine();
			int newAddedActorId=getNewAddedActorId(fName, lName);
			System.out.println("Enter film id for search if exist: ");
			int filmId=Integer.parseInt(sp.nextLine());
			addExistingActorToFilm(newAddedActorId, filmId);
			break;
		default:
			break;
		}
	}

	public static int getNewAddedActorId(String firstName, String lastName) {
		int newId = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "123456789");
				CallableStatement cs = con.prepareCall("call insert_actor(?,?,?,?)")) {
			cs.setString(1, firstName);
			cs.setString(2, lastName);
			cs.setString(3, getCurrentDateTime());
			cs.registerOutParameter("new_id", Types.INTEGER);
			cs.execute();
			newId = cs.getInt("new_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newId;
	}

	public static void addExistingActorToFilm(int actor_id, int film_id) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "123456789");
				PreparedStatement ps = con
						.prepareStatement("insert into film_actor(actor_id,film_id,last_update) values(?,?,?)")) {
			if (searchFilmInDB(actor_id) != 0 && searchActorInDB(film_id) != 0) {
				ps.setInt(1, searchActorInDB(actor_id));
				ps.setInt(2, searchFilmInDB(film_id));
				ps.setString(3, getCurrentDateTime());
				ps.execute();
			}

		} catch (SQLException e) {
			System.out.println("Can not add actor in table film_actor, because " + e.getMessage());
		}
	}

	public static void addActorsInTableActor(String firstName, String lastName) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "123456789");
				PreparedStatement ps = con
						.prepareStatement("insert into actor(first_name,last_name,last_update) values(?,?,?)")) {

			ps.setString(1, firstName);
			ps.setString(2, lastName);

			ps.setString(3, getCurrentDateTime());
			ps.execute();

		} catch (SQLException e) {
			System.out.println("Can not add new actor in table actor, because " + e.getMessage());
		}
	}

	private static String getCurrentDateTime() {
		String locDate = String.valueOf(LocalDate.now());
		LocalTime locTime = LocalTime.now();
		String time = String.valueOf(locTime.getHour()) + ":" + String.valueOf(locTime.getMinute()) + ":"
				+ locTime.getSecond();
		String date = locDate + " " + time;
		return date;
	}

	private static int searchFilmInDB(int film_id) {
		int id = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from film where film_id=?")) {
			ps.setInt(1, film_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Can not get film with these id " + film_id + ", because " + e.getMessage());
		}
		return id;

	}

	private static int searchActorInDB(int actor_id) {
		int id = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("select * from actor where actor_id=(?)")) {
			ps.setInt(1, actor_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Can not search in table actor, beacuse " + e.getMessage());
		}
		return id;
	}
}
