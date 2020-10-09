package swift.loops;

import java.util.Scanner;

public class Task4a_StringWoVowels {
	public static void main(String[] args) {
		

		Scanner sp = new Scanner(System.in);
		char[] consonant = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

		String sentence = sp.nextLine();
		String[] array = new String[sentence.length()];

		for (int i = 0; i < array.length; i++) {
			array[i] = String.valueOf(sentence.charAt(i));
		}

		for (int i = 0; i < array.length; i++) {
			boolean flag = false;

			for (int j = 0; j < consonant.length; j++) {
				boolean noEquals = array[i].equals(String.valueOf(consonant[j]));
				if (!noEquals) {
					flag = true;

				} else {
					flag = false;
					break;

				}

			}
			if (flag) {
				System.out.printf("%s", array[i]);
			}

		}
	}

}
