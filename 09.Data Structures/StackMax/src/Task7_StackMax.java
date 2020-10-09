import java.util.LinkedList;
import java.util.Scanner;

public class Task7_StackMax {
	private static LinkedList<Integer> stack = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String[] line = sp.nextLine().split(" ");
		String command = line[0];

		while (!"END".equals(command)) {
			if ("PUSH".equals(command)) {
				stack.push(Integer.parseInt(line[1]));
			} else if ("POP".equals(command)) {
				System.out.println(stack.pop());
			} else if ("MAX".equals(command)) {
				System.out.println(searchMaxNumberInStack());
			}
			line = sp.nextLine().split(" ");
			command = line[0];
			if (command.equals("END")) {
				for (Integer i : stack) {
					System.out.print(i + " ");
				}
			}
		}
	}

	private static int searchMaxNumberInStack() {
		int maxNumber = Integer.MIN_VALUE;
		for (Integer number : stack) {
			if (number > maxNumber) {
				maxNumber = number;
			}
		}
		return maxNumber;

	}

}
