package swift.loops;

import java.util.Scanner;

public class Task1c_PrintSumOfDigits {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);

		String number = sp.nextLine();
		String arrayOfNumber[] = new String[number.length()];
		int sumOfDigits = 0;

		for (int i = 0; i < number.length(); i++) {
			arrayOfNumber[i] = String.valueOf(number.charAt(i));
			sumOfDigits += Integer.parseInt(arrayOfNumber[i]);
		}
		System.out.println(sumOfDigits);

	}

}
