package swift.tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task0c_IsCorrectSQLInsert {

	public static boolean isCorrectSQLInsertQuery(String input) {

		Pattern pattern = Pattern.compile(
				"^(INSERT)(\\s+)(INTO)(\\s+)(\\w+)(\\s*)(\\((\\w+\\,*)+\\))(\\s+)(VALUES)(\\s?)(\\((\\w+\\,*)+\\)\\;)");

		Matcher matcher = pattern.matcher(input.toUpperCase());
		Pattern patternForScope = Pattern.compile("(\\((\\w+\\,*)+\\))");
		Matcher matcherForScope = patternForScope.matcher(input);
		String firstScope = " ";
		String secondScope = " ";
		int counter = 1;
		while (matcherForScope.find()) {
			if (counter == 1) {
				firstScope = matcherForScope.group();
			} else if (counter == 2) {
				secondScope = matcherForScope.group();
				break;
			}
			counter++;
		}
		if (firstScope.equals(secondScope) && matcher.find() == true) {
			return true;
		} else {
			return false;
		}
	}
}
