package main;

import java.util.List;
import java.util.Scanner;

import connection.MySqlAddressData;
import data.Address;

public class Task2_AddressDB {
	private static Scanner sp = new Scanner(System.in);

	public static void main(String[] args) {

		menu();

	}

	private static void menu() {
		System.out.println("------------Menu------------");
		System.out.println("1. Get full address by id ");
		System.out.println("2. Add new address in DB ");
		System.out.println("3. Get all addresses in municipality");
		System.out.println("Enter choice: ");
		int choice = Integer.parseInt(sp.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter id for searching address in DB:");
			int id = Integer.parseInt(sp.nextLine());
			System.out.println(MySqlAddressData.getFullAddress(id));
			break;
		case 2:
			System.out.println("Enter street id: ");
			int streetId = Integer.parseInt(sp.nextLine());
			System.out.println("Enter number:");
			int number = Integer.parseInt(sp.nextLine());
			System.out.println("Enter apartmen number:");
			int apartmenNo = Integer.parseInt(sp.nextLine());
			Address address = new Address(streetId, number, apartmenNo);
			MySqlAddressData.addAddress(address);
			break;
		case 3:
			System.out.println("Enter municipality name for searching addresses in it: ");
			String municipalityName = sp.nextLine();
			System.out.println("Addresses in " + municipalityName + ":");
			List<Address> addresses = MySqlAddressData.getAddresses(municipalityName);
			for (Address a : addresses) {
				System.out.println(a.printStreet());
			}
			break;
		}
	}

}
