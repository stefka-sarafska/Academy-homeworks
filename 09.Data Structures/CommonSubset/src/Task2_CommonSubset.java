import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2_CommonSubset {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String[] input = sp.nextLine().split(" ");
		int sizeOfFirstLine = Integer.parseInt(input[0]);
		int sizeOfSecondLine = Integer.parseInt(input[1]);

		List<Integer> firstLine = new ArrayList<>();
		List<Integer> secondLine = new ArrayList<>();

		for (int i = 0; i < sizeOfFirstLine; i++) {
			firstLine.add(sp.nextInt());
		}

		boolean hasCommonElement = false;
		for (int i = 0; i < sizeOfSecondLine; i++) {
			int searchedElement = sp.nextInt();
			secondLine.add(searchedElement);
			if (firstLine.contains(searchedElement)) {
				System.out.print(searchedElement + " ");
				hasCommonElement = true;
			}
		}
		if (!hasCommonElement) {
			System.out.println("NO");
		}

	}

}
