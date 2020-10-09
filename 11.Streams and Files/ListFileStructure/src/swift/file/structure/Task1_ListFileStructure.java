package swift.file.structure;

import java.io.File;
import java.util.Scanner;

public class Task1_ListFileStructure {
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
			System.out.println(directory.getAbsolutePath());
		}
	}

}
