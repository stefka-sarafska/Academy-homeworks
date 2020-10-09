package com.data.types.lab;

public class Task7_PersonCharacteristics {

	public static void main(String[] args) {
		String firstName = "Georgi";
		String lastName = "Georgev";
		short yearOfBirth = 2002;
		float weight = 48.3f;
		short height = 156;
		String profession = "student";

		byte age = (byte) (2020 - yearOfBirth);

		System.out.printf("%s %s is %d years old. His weight is %.1f and he is %d cm tall. He is %s.", firstName,
				lastName, age, weight, height, profession);

	}

}
