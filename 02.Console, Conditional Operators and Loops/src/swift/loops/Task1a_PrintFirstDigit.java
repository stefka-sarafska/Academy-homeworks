package swift.loops;

import java.util.Scanner;

public class Task1a_PrintFirstDigit {

	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
		int number = sp.nextInt();
		String numberToString = String.valueOf(number);

		System.out.println(numberToString.substring(0, 1));
	}
}
