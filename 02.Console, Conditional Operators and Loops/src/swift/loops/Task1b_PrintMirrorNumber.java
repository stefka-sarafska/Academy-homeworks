package swift.loops;

import java.util.Scanner;

public class Task1b_PrintMirrorNumber {
	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
		String number = sp.nextLine();

		String arrayOfNumber[] = new String[number.length()];

		for (int i = 0; i < number.length(); i++) {
			arrayOfNumber[i] = String.valueOf(number.charAt(i));

		}
		for (int i = number.length() - 1; i >= 0; i--) {
			System.out.printf("%s", arrayOfNumber[i]);
		}

	}
}
