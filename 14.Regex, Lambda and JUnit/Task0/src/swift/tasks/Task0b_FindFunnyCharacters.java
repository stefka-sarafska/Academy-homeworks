package swift.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task0b_FindFunnyCharacters {

	public static List<String> findAndPrintFunnyCharacters(String input) {
		List<String> funnyCharacters = new ArrayList<String>();
		Pattern pattern = Pattern.compile("[^\\w~+!@#$%^&*()+\\-=/\\\\]");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			System.out.println("Found text " + matcher.group() + " starts at index " + matcher.start()
					+ " and ends at index " + matcher.end());
			funnyCharacters.add(matcher.group());
		}
		return funnyCharacters;
	}
}
