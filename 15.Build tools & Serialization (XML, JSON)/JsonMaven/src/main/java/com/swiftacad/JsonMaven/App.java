package com.swiftacad.JsonMaven;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		writeToJson("jsonFormat.json");
		readFromJson("jsonFormat.json");
	}

	private static void writeToJson(String fileName) {
		try (FileOutputStream writer = new FileOutputStream(fileName)) {
			Address addresss = new Address("21 2nd Street", "New York", "NY", 10021);
			PhoneNumber homePhoneNumner = new PhoneNumber("home", "212 555-1234");
			PhoneNumber phoneNumner = new PhoneNumber(null, "646 555-4567");
			List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>(Arrays.asList(homePhoneNumner, phoneNumner));
			Person person = new Person("John Smith", 20, addresss, phoneNumbers);
			Gson gson = new Gson();
			String jsonFormat = gson.toJson(person);
			writer.write(jsonFormat.getBytes());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFromJson(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String jsonObject = reader.readLine();
			Gson gson = new Gson();
			Person person = gson.fromJson(jsonObject, Person.class);
			System.out.println(person);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
