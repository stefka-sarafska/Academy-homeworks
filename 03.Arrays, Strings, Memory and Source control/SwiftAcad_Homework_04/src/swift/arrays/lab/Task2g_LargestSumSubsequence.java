package swift.arrays.lab;

import java.util.Scanner;

public class Task2g_LargestSumSubsequence {
	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		int[] numbers = new int[n];

		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int firstIndex = 0;
		int lastIndex = 0;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sp.nextInt();

			if (sum < numbers[i] && sum < 0) {
				firstIndex = i;
				lastIndex = i;
				sum = numbers[i];
				maxSum = sum;
				continue;
			}
			sum += numbers[i];
			if (sum > maxSum) {
				maxSum = sum;
				lastIndex = i;
			}

		}

		for (int i = firstIndex; i <= lastIndex; i++) {
			System.out.print(numbers[i] + " ");
		}

	}
}
