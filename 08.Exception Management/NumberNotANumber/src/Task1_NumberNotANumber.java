import java.util.Scanner;

public class Task1_NumberNotANumber {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String currentLine = sp.nextLine();

		while (!"END".equals(currentLine)) {
			try {
				Integer.parseInt(currentLine);
				System.out.println("Number");

			} catch (NumberFormatException e) {
				System.out.println("Not a number!");
			}

			currentLine = sp.nextLine();
		}

	}

}
