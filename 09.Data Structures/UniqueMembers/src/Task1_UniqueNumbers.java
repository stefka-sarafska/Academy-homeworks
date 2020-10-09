import java.util.HashSet;
import java.util.Scanner;

public class Task1_UniqueNumbers {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		HashSet<Integer> numbers = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			numbers.add(sp.nextInt());
		}
		for (Integer i : numbers) {
			System.out.print(i + " ");
		}
	}
}
