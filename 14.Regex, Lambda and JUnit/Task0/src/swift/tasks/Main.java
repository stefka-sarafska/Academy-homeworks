package swift.tasks;
import java.util.Scanner;

public class Main {
	private static Scanner sp = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Input string:");
		String input = sp.nextLine();
		menu(input);

	}

	private static void menu(String input) {
		System.out.println("1. Finding integers in string");
		System.out.println("2. Finding funny characters in string");
		System.out.println("3. Is input string is a correct SQL insert query");
		int choice = Integer.parseInt(sp.nextLine());
		switch (choice) {
		case 1:
			Task0a_FindIntegers.findAndPrintIntegers(input);
			break;
		case 2:
			Task0b_FindFunnyCharacters.findAndPrintFunnyCharacters(input);
			break;
		case 3:
			System.out.println(Task0c_IsCorrectSQLInsert.isCorrectSQLInsertQuery(input));
			break;
		default:
			break;
		}
	}
}
