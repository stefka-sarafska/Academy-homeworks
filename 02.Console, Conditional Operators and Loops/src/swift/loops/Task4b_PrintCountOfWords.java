package swift.loops;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task4b_PrintCountOfWords {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String sentence = sp.nextLine();
		String[] partsOfSentence = sentence.split(" ");
		int counter = 0;

		for (int i = 0; i < partsOfSentence.length; i++) {
			if (partsOfSentence[i].matches("[a-zA-Z]+")) {
				counter++;
			}
		}
		System.out.println(counter);

	}

}
