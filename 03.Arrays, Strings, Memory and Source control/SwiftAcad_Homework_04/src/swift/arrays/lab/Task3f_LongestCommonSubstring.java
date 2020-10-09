package swift.arrays.lab;

import java.util.Scanner;

public class Task3f_LongestCommonSubstring {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String firstInput = sp.nextLine();
		String secondInput = sp.nextLine();

		char[] array = firstInput.toCharArray();
		char[] arrayToCompare = secondInput.toCharArray();

		String tempLongestSubstring = " ";
		String longestCommonSubstring = " ";

		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < arrayToCompare.length; j++) {
				if (array[i] == arrayToCompare[j]) {
					tempLongestSubstring += array[i];
					if (longestCommonSubstring.length() < tempLongestSubstring.length()) {
						longestCommonSubstring = tempLongestSubstring;
					}
					if (j == arrayToCompare.length - 1) {
						tempLongestSubstring = " ";
					}
					break;
				} else {
					if (longestCommonSubstring.length() < tempLongestSubstring.length()) {
						longestCommonSubstring = tempLongestSubstring;
					} else if (j == arrayToCompare.length - 1) {
						tempLongestSubstring = " ";
					}

				}
			}

		}
		System.out.println(longestCommonSubstring.trim());
	}
}
