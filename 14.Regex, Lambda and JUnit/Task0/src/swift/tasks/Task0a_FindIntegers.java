package swift.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task0a_FindIntegers {

	public static List<String> findAndPrintIntegers(String input) {
		List<String> integers = new ArrayList<>();
		Pattern pattern = Pattern.compile("-?\\d+");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			System.out.println("Found integer " + matcher.group() + " starts at index " + matcher.start()
					+ " and ends at index " + matcher.end());
			integers.add(matcher.group());
		}
		return integers;
	}
}
