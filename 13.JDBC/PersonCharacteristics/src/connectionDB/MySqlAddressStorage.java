package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exception.DALException;
import person.Address;

public class MySqlAddressStorage implements AddressStorage {

	@Override
	public Address getAddress(int id) throws DALException {
		Address address = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen_registrations", "root",
				"123456789"); PreparedStatement ps = con.prepareStatement("select * from addresses where id=?")) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				address = new Address(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (address == null) {
			throw new DALException("Can not get address with id " + id);
		} else {
			return address;
		}
	}

	@Override
	public int insertAddress(Address address) throws DALException {
		int addressId = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen_registrations", "root",
				"123456789");
				PreparedStatement ps = con.prepareStatement(
						"insert into addresses(country,city,municipality,postal_code,street,number,floor,apartmentNo) values (?,?,?,?,?,?,?,?)")) {
			ps.setString(1, address.getCountry());
			ps.setString(2, address.getCity());
			ps.setString(3, address.getMunicipality());
			ps.setString(4, address.getPostalCode());
			ps.setString(5, address.getStreet());
			ps.setInt(6, address.getNumber());
			ps.setInt(7, address.getFloor());
			ps.setInt(8, address.getApartmentNo());
			ps.execute();
		    addressId = getAddressId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(addressId==0) {
			throw new DALException("Can not insert address with these properties.");
		}else {
			return addressId;
		}

	}

	private int getAddressId() {
		int lastAddressId = 0;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen_registrations", "root",
				"123456789"); PreparedStatement ps = con.prepareStatement("select id from addresses")) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lastAddressId = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastAddressId;
	}

}
