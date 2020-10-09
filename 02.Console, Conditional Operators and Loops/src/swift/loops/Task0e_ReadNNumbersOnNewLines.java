package swift.loops;

import java.util.Scanner;

public class Task0e_ReadNNumbersOnNewLines {
	
	public static void main(String[] args) {
		
		Scanner sp = new Scanner(System.in);
		int numbersCounter = sp.nextInt();
		int[] arrayOfNumbers = new int[numbersCounter];

		for (int i = 0; i < numbersCounter; i++) {
			int number = sp.nextInt();
			arrayOfNumbers[i] = number;
		}

		for (int i = 0; i < numbersCounter; i++) {
			System.out.printf("%d ", arrayOfNumbers[i]);
		}
	}

}
