package swift.arrays.lab;

import java.util.Scanner;

public class Task2a_PrintLargestNumber {
	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
		int n = Integer.parseInt(sp.nextLine());
		int[] numbers = new int[n];
		int maxNumber = Integer.MIN_VALUE;

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sp.nextInt();
			if (numbers[i] > maxNumber) {
				maxNumber = numbers[i];
			}

		}
		System.out.println(maxNumber);
	}

}
