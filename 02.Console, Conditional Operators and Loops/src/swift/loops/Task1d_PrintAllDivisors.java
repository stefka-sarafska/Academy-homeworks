package swift.loops;

import java.util.Scanner;

public class Task1d_PrintAllDivisors {
	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
		int number = sp.nextInt();

		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				System.out.printf("%d ", i);
			}
		}

	}

}
