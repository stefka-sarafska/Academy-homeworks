package swift.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task3b_PrintLetterCount {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String word = sp.nextLine();
		word = word.toLowerCase();
		char[] arr = word.toCharArray();
		Arrays.sort(arr);

		char previousLetter = ' ';
		for (int i = 0; i < arr.length; i++) {
			if (previousLetter == arr[i]) {
				continue;
			}
			previousLetter = arr[i];
			int counter = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					counter++;
				}
			}
			System.out.println(arr[i] + "(" + counter + ")");
		}
	}
}
