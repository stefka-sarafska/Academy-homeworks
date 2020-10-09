package swift.loops;

import java.util.Scanner;

public class Task5_PersonCharacteristics {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		sp.nextLine();
		

		for (int i = 0; i < n; i++) {
			String firstName = sp.nextLine();
			String lastName = sp.nextLine();
			short bornDate = Short.parseShort(sp.nextLine());
			double weight = Double.parseDouble(sp.nextLine());
			short height= Short.parseShort(sp.nextLine());
			String profession = sp.nextLine();
			int age = 2020 - bornDate;
			System.out.printf("%s %s is %d years old. He was born in %d. His weight is %.2f and he is %d cm tall. He is a %s", firstName,
					lastName, age,bornDate, weight, , profession);
			
			if (age < 18) {
				System.out.printf("%s %s is ender-aged.",firstName,lastName);
				
			}
			System.out.println();
		}
	}

}
