package swift.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task2i_FindKInSorted {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);

		int n = sp.nextInt();
		int numberForSearch = sp.nextInt();
		int[] arrayOfNumbers = new int[n];

		for (int i = 0; i < arrayOfNumbers.length; i++) {
			arrayOfNumbers[i] = sp.nextInt();
		}

		int indexOfSearchedNum = Arrays.binarySearch(arrayOfNumbers, numberForSearch);
		if (indexOfSearchedNum >= 0) {
			System.out.println(indexOfSearchedNum);
		} else {
			System.out.println("NO");
		}
	}

}
