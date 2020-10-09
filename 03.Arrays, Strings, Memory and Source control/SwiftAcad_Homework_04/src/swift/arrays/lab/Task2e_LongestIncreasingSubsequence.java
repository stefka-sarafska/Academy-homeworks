package swift.arrays.lab;

import java.util.Scanner;

public class Task2e_LongestIncreasingSubsequence {
	public static void main(String[] args) {
		 Scanner sp = new Scanner(System.in);
	        int n = sp.nextInt();
	        int[] numbers = new int[n];

	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = sp.nextInt();
	        }

	        int countNewLength = 1;
	        int maxNewArrayLength = 0;
	        for (int i = 1; i < numbers.length; i++) {
	            if (numbers[i] > numbers[i - 1]) {
	                countNewLength++;
	                if (countNewLength > maxNewArrayLength) {
	                    maxNewArrayLength = countNewLength;
	                }
	            } else {
	                countNewLength = 1;
	            }

	        }

	        int[] longestIncreasingSeries = new int[maxNewArrayLength];
	        int counterForNewArrayElement = 0;
	        for (int i = 1; i < numbers.length; i++) {
	            if (numbers[i] > numbers[i - 1]) {
	                longestIncreasingSeries[counterForNewArrayElement] = numbers[i - 1];
	                counterForNewArrayElement++;
	                longestIncreasingSeries[counterForNewArrayElement] = numbers[i];
	                if (counterForNewArrayElement == maxNewArrayLength - 1) {
	                    break;
	                }
	            } else {
	                counterForNewArrayElement = 0;
	            }
	        }
	        for (int num : longestIncreasingSeries) {
	            System.out.printf("%d ", num);

	        }
	}

}
