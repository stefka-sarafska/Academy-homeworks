
import java.io.File;
import java.util.Scanner;

public class Task2_ListRelativeFileStructure {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		File inputFile = new File(path);
		printAllFiles(inputFile);
		sc.close();
	}

	private static void printAllFiles(File directory) {
		if (directory.isDirectory()) {
			for (File file : directory.listFiles()) {
				printAllFiles(file);
			}
		} else {
			File parentDirectory = new File(directory.getParent());
			System.out.println(parentDirectory.getName() + File.separator + directory.getName());
		}
	}

}
