package swift.arrays.lab;

import java.util.Scanner;

public class Task2d_PrintSplitIndex {
	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < array.length; i++) {
			array[i] = sp.nextInt();
		}

		int leftSum = 0;
		boolean flag = true;
		for (int i = 0; i < array.length; i++) {
			flag = true;
			leftSum += array[i];
			int rightSum = 0;
			for (int j = array.length - 1; j > i; j--) {
				rightSum += array[j];
			}
			if (leftSum == rightSum) {
				System.out.println(i);
				break;
			} else {
				flag = false;
			}
		}

		if (!flag) {
			System.out.println("NO");
		}

	}
}
