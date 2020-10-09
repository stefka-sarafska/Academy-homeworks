package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import data.Address;

public class MySqlAddressData {

	public static Address getFullAddress(int id) {
		Address address = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressdb", "root", "123456789");
				PreparedStatement ps = con.prepareStatement(
						"SELECT addresses.number,addresses.apartmenNo,streets.name,municipalities.name,populated_areas.name,regions.name,countries.name"
								+ " FROM addresses" + " JOIN streets ON addresses.street_id=streets.id"
								+ " JOIN municipalities ON streets.municipality_id=municipalities.id"
								+ " JOIN populated_areas ON municipalities.populated_area_id=populated_areas.id"
								+ " JOIN regions ON populated_areas.region_id=regions.id"
								+ " JOIN countries  ON regions.country_id=countries.id" + " WHERE addresses.id=?")) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				address = new Address(rs.getInt("addresses.number"), rs.getString("streets.name"),
						rs.getInt("addresses.apartmenNo"), rs.getString("municipalities.name"),
						rs.getString("populated_areas.name"), rs.getString("regions.name"),
						rs.getString("countries.name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	public static void addAddress(Address address) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressdb", "root", "123456789");
				PreparedStatement ps = con.prepareCall("{CALL add_address(?,?,?)}")) {
			ps.setInt(1, address.getStreet_id());
			ps.setInt(2, address.getNumber());
			ps.setInt(3, address.getApartmenNo());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Address> getAddresses(String municipalityName) {
		List<Address> addresses = new LinkedList<Address>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressdb", "root", "123456789");
				PreparedStatement ps = con.prepareStatement("SELECT addresses.number,addresses.apartmenNo,streets.name"
						+ " FROM municipalities" + " JOIN streets ON municipalities.id=streets.municipality_id"
						+ " JOIN addresses ON addresses.street_id=streets.id" + " WHERE municipalities.name=?")) {
			ps.setString(1, municipalityName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Address address = new Address(rs.getInt("addresses.number"), rs.getString("streets.name"),
						rs.getInt("addresses.apartmenNo"));
				addresses.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
	}
}