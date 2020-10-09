package swift.loops;

import java.util.Scanner;

public class Task2a_PrintSumOfN {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);

		int numbersCounter = sp.nextInt();
		int sumOfNumbers = 0;

		for (int i = 0; i < numbersCounter; i++) {
			int number = sp.nextInt();
			sumOfNumbers += number;
		}
		
		System.out.println(sumOfNumbers);

	}

}
