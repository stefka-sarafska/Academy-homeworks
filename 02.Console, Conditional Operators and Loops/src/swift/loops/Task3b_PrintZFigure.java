package swift.loops;

import java.util.Scanner;

public class Task3b_PrintZFigure {
	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
		final String SING = "*";
		int n = sp.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("%s  ", SING);

		}
		for (int i = 0; i < n - 2; i++) {
			System.out.println();
			for (int j = 0; j < (n * 3 - 6) - i * 3; j++) {
				System.out.print(" ");
			}
			System.out.print(SING);

		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.printf("%s  ", SING);
		}
	}
}
