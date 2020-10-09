import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task5_ChildPlay {
	private static Scanner sp = new Scanner(System.in);
	private static List<Integer> heightsOfChildren = new LinkedList<>();
	private static int count = -1;

	public static void main(String[] args) {

		int numberOfChildren = sp.nextInt();
		addingHeightsInListByInput(numberOfChildren);
		compareAndRemoveLesserHeight();
		System.out.println(count);
	}

	private static void addingHeightsInListByInput(int numberOfChildren) {
		for (int i = 0; i < numberOfChildren; i++) {
			heightsOfChildren.add(sp.nextInt());
		}
		sp.close();
	}

	private static void compareAndRemoveLesserHeight() {
		int previousHeight = 0;
		int currHeight = 0;
		boolean flag = false;

		do {
			previousHeight = 0;
			flag = false;
			count++;
			for (int i = 1; i < heightsOfChildren.size(); i++) {
				previousHeight = heightsOfChildren.get(i - 1);
				currHeight = heightsOfChildren.get(i);
				if (previousHeight > currHeight) {
					heightsOfChildren.remove(i - 1);
					i--;
					flag = true;
					if (heightsOfChildren.size() <= 1 && count == 0) {
						flag = false;
						break;
					}
					continue;
				}
			}
		} while (flag != false);
	}
}