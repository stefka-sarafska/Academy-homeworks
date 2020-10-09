import java.io.File;
import java.util.Scanner;

public class Task2_FileStructure {
	private static FileSystemObject[] files = new FileSystemObject[50];
	private static int countFiles = 0;
	public static int countLines = 0;

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String line = sp.nextLine();
		String[] input = line.split(" ");
		String command = input[0];

		while (!"END".equals(command)) {
			try {
				if ("mkdir".equals(command)) {
					countLines++;
					makeDirectories(input);
				} else if ("touch".equals(command)) {
					countLines++;
					makeFiles(input);
				}
			} catch (FileException e) {
				System.out.println(e.getMessage());
			}

			line = sp.nextLine();
			input = line.split(" ");
			command = input[0];

			if (command.equals("END")) {
				showFiles();
			}
		}
	}

	private static FileSystemObject searchFileByName(String name) {
		for (FileSystemObject f : files) {
			if (f != null && name.equals(f.getName())) {
				return f;
			}
		}
		return null;
	}

	private static void makeDirectories(String[] input) throws FileException {
		String fileName = input[1];
		String[] filesInput = input[1].split("/");
		if (filesInput.length == 1) {
			if (isNameCorrect(fileName)) {
				files[countFiles] = new FolderObject(fileName);
				countFiles++;
			}
		} else {
			FolderObject parent = null;
			for (int i = 0; i < filesInput.length; i++) {
				String currFileName = filesInput[i];
				if (searchFileByName(currFileName) != null) {
					if (searchFileByName(currFileName) instanceof FolderObject) {
						parent = (FolderObject) searchFileByName(currFileName);
						continue;
					} else if (searchFileByName(currFileName) instanceof FileObject) {
						throw new FileException("Illegal operation", countLines);
					}

				} else {
					if (i == filesInput.length - 1) {
						if (isNameCorrect(currFileName)) {
							files[countFiles] = new FolderObject(parent, currFileName);
							if (files[countFiles] instanceof FolderObject) {
								parent.setChildren(files[countFiles]);
							} else if (files[countFiles] instanceof FileObject) {
								throw new FileException("Illegal operation", countLines);
							}
							countFiles++;
						}
					} else {
						throw new FileException("Directory does not exist", countLines);

					}
				}
			}
		}
	}

	private static void makeFiles(String[] input) throws FileException {
		String fileName = input[1];
		String[] filesInput = input[1].split("/");
		if (filesInput.length == 1) {
			if (isNameCorrect(fileName) && isFileNameCorrect(fileName)) {
				files[countFiles] = new FolderObject(fileName);
				countFiles++;
			}
		} else {
			FileSystemObject parent = null;
			for (int i = 0; i < filesInput.length; i++) {
				String currFileName = filesInput[i];
				if (searchFileByName(currFileName) != null) {
					parent = searchFileByName(currFileName);
					continue;
				} else {
					if (i == filesInput.length - 1 && isNameCorrect(currFileName)) {
						if (isFileNameCorrect(currFileName) && isNameCorrect(currFileName)) {
							files[countFiles] = new FileObject(parent, currFileName);
							countFiles++;
						}
					} else if (parent instanceof FileObject) {
						throw new FileException("Illegal operation", countLines);

					}
				}
			}
		}
	}

	private static boolean isNameCorrect(String name) throws FileException {
		String regex = "([A-Za-z0-9()_!.&])+";
		String firstLetterOfName = String.valueOf(name.charAt(0));
		if (name == null || firstLetterOfName.equals("(") || firstLetterOfName.equals(")")
				|| firstLetterOfName.equals("_") || firstLetterOfName.equals("!") || firstLetterOfName.equals(".")
				|| firstLetterOfName.equals("&")) {
			throw new FileException("Invalid name specified", countLines);
		}
		if (name == null || !name.matches(regex)) {
			throw new FileException("Invalid name specified", countLines);
		}
		return true;

	}

	public static boolean isFileNameCorrect(String name) throws FileException {
		String fileExtension = name.substring(name.indexOf("."), name.length());
		if (fileExtension.length() > 6) {
			throw new FileException("Invalid name specified");
		}
		return true;
	}

	private static void showFiles() {
		for (FileSystemObject f : files) {
			if (f != null)
				System.out.println(f.getName() + " --parent-- " + f.getParentName());
		}

	}
}