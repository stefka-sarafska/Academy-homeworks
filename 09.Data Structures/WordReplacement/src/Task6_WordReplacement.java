import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task6_WordReplacement {
	private static Scanner sp = new Scanner(System.in);
	private static List<String> sentance = new ArrayList<>();
	private static Map<String, String> map = new HashMap<>();

	public static void main(String[] args) {
		String[] line = sp.nextLine().split(" ");
		addingWordsInListFromInput(line);
		addingWordsInMap();
		printNewSentenceByWordsInMap();
		sp.close();

	}

	private static void printNewSentenceByWordsInMap() {
		for (int i = 0; i < sentance.size(); i++) {
			if (!map.isEmpty() && map.containsKey(sentance.get(i).toLowerCase())) {
				String newWord = map.get(sentance.get(i).toLowerCase());
				sentance.remove(i);
				sentance.add(i, newWord);
			}
		}
		for (int i = 0; i < sentance.size(); i++) {
			if (i == sentance.size() - 1) {
				System.out.print(sentance.get(i) + ".");
				break;
			}
			System.out.print(sentance.get(i) + " ");

		}
	}

	private static void addingWordsInMap() {
		int n = Integer.parseInt(sp.nextLine());
		for (int i = 0; i < n; i++) {
			String[] input = sp.nextLine().split(" ");
			map.put(input[0], input[1]);
		}
	}

	private static void addingWordsInListFromInput(String[] line) {
		for (int i = 0; i < line.length; i++) {
			String word = line[i];
			if (i == line.length - 1) {
				if (word.endsWith(".")) {
					sentance.add(word.substring(0, word.length() - 1));
				} else {
					sentance.add(word);
				}
			} else {
				sentance.add(word);
			}
		}
	}
}
