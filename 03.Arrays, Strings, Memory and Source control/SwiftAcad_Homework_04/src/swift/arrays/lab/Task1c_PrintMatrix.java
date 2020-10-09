package swift.arrays.lab;

import java.util.Scanner;

public class Task1c_PrintMatrix {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		int[][] array = new int[n][n];

		int counter = 1;
		for (int i = 0; i < 2 * n - 1; i++) {

			if (i % 2 == 1) {
				for (int k = 0; k <= i; k++) {
					if (k < n && i - k < n) {
						array[k][i - k] = counter;
						counter++;
					}
				}
			} else if (i % 2 == 0) {
				for (int k = 0; k <= i; k++) {
					if (i - k < n && k < n) {
						array[i - k][k] = counter;
						counter++;
					}

				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {

				System.out.print(array[i][j]);
				System.out.print("\t");

				if (j == n - 1) {
					System.out.println();

				}
			}
		}
	}

}
