package swift.arrays.lab;

import java.util.Scanner;

public class Task3e_ConvertibleStrings {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String sentence = sp.nextLine();
		String sentenceToCompare = sp.nextLine();

		char[] array = sentence.toCharArray();
		char[] arr = sentenceToCompare.toCharArray();

		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if (sentence.contains(String.valueOf(arr[i]))) {
				flag = true;
			} else {
				flag = false;
				break;
			}

		}
		if (flag) {
			System.out.println(flag);
		} else {
			System.out.println(flag);
		}
	}
}
