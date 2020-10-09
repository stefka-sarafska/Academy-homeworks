import java.util.LinkedList;
import java.util.Scanner;

public class Task3_ParenthesesMatching {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String input = sp.nextLine();
		char[] expressionToMatch = input.toCharArray();

		LinkedList<Character> brackets = new LinkedList<>();

		if (isBracketsCorrect(expressionToMatch, brackets)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		sp.close();
	}

	private static boolean isBracketsCorrect(char[] expressionToMatch, LinkedList<Character> brackets) {
		boolean isBrachetsCorrect = false;
		for (char element : expressionToMatch) {
			if (element == '[' || element == '(' || element == '{') {
				brackets.push(element);
			} else if (element == ']' || element == ')' || element == '}') {
				char lastOpenBracket = brackets.peek();
				if (element == ']') {
					if (lastOpenBracket == '[') {
						brackets.pop();
						isBrachetsCorrect = true;
					} else {
						isBrachetsCorrect = false;
						break;
					}
				} else if (element == '}') {
					if (lastOpenBracket == '{') {
						brackets.pop();
						isBrachetsCorrect = true;
					} else {
						isBrachetsCorrect = false;
						break;
					}
				} else if (element == ')') {
					if (lastOpenBracket == '(') {
						brackets.pop();
						isBrachetsCorrect = true;
					} else {
						isBrachetsCorrect = false;
						break;
					}
				}
			}
		}
		return isBrachetsCorrect;
	}

}
