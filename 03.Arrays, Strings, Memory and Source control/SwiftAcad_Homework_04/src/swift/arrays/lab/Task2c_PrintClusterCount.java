package swift.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task2c_PrintClusterCount {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sp.nextInt();
		}
		Arrays.sort(numbers);
		int counter = 1;
		int maxCount = 0;

		for (int i = 1; i < numbers.length; i++) {
			int previosNumber = numbers[i - 1];
			if (numbers[i] == previosNumber) {
				counter++;

			} else {
				if (maxCount <= counter) {
					maxCount = counter;
					counter = 1;
				}

			}

		}
		System.out.println(maxCount);
	}
}
