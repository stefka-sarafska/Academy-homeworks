package swift.arrays.lab;

import java.util.Scanner;

public class Task2h_PrintOddFrequencyNumber {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int arrayLength = sp.nextInt();
		int[] numbers = new int[arrayLength];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sp.nextInt();
		}

		boolean isSematic = false;
		int sematicNumber = 0;
		for (int i = 0; i < numbers.length; i++) {
			int searchedNumber = numbers[i];
			int counter = 1;
			for (int j = i + 1; j < numbers.length; j++) {
				if (searchedNumber == numbers[j]) {
					counter++;
				}

			}
			if (counter % 2 == 0) {
				isSematic = false;
			} else {
				isSematic = true;
				sematicNumber = searchedNumber;
				break;
			}
		}
		if (isSematic) {
			System.out.println(sematicNumber);
		}

	}

}
