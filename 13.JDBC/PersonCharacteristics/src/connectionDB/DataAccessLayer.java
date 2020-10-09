package connectionDB;

import java.util.Scanner;

import Exception.DALException;
import person.Address;

public class DataAccessLayer {
	private static Scanner sp = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			menu();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void menu() throws NumberFormatException, DALException {
		MySqlAddressStorage connector = new MySqlAddressStorage();
		System.out.println("------Menu-----");
		System.out.println("1. Search address in DB by id");
		System.out.println("2. Insert new address in DB");
		System.out.println("Enter your choice [1-2]: ");
		int choice = Integer.parseInt(sp.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter address id for search: ");
			System.out.println(connector.getAddress(Integer.parseInt(sp.nextLine())));
			break;
		case 2:
			if (getNewAddress() != null) {
				Address newAddress = getNewAddress();
				System.out.println("New added address id: " + connector.insertAddress(newAddress));
			} else {
				throw new DALException("Wrong input for adding new address in DB!");
			}
			break;

		default:
			System.out.println("Invalid input!");
			break;

		}
	}

	private static Address getNewAddress() {
		System.out.println("Enter new address properties:");
		System.out.println("Country: ");
		String country = sp.nextLine();
		System.out.println("City: ");
		String city = sp.nextLine();
		System.out.println("Municipality: ");
		String municipality = sp.nextLine();
		System.out.println("PostalCode: ");
		String postalCode = sp.nextLine();
		System.out.println("Street: ");
		String street = sp.nextLine();
		System.out.println("Number: ");
		int number = Integer.parseInt(sp.nextLine());
		System.out.println("Floor: ");
		int floor = Integer.parseInt(sp.nextLine());
		System.out.println("ApartmentNo: ");
		int apartmentNo = Integer.parseInt(sp.nextLine());
		Address newAddress = new Address(country, city, municipality, postalCode, street, number, floor, apartmentNo);
		return newAddress;
	}

}
