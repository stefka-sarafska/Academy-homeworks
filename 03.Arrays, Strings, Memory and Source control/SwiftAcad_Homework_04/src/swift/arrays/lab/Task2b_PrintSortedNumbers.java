package swift.arrays.lab;
import java.util.Arrays;
import java.util.Scanner;

public class Task2b_PrintSortedNumbers {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sp.nextInt();
		}
		Arrays.sort(numbers);

		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}

}
