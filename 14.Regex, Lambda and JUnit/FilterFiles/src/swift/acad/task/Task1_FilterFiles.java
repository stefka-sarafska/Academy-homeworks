package swift.acad.task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1_FilterFiles {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);

		int n = Integer.parseInt(sp.nextLine());
		List<String> files = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			files.add(sp.nextLine());
		}
		sp.close();

		List<String> graphicFiles = getGraphicFilesFromInput(files);

		for (String graphicFile : graphicFiles) {
			System.out.println(graphicFile);
		}

	}

	public static List<String> getGraphicFilesFromInput(List<String> files) {
		List<String> fileGraphicExtention = new ArrayList<>(Arrays.asList(".jpg", ".png", ".bmp", ".gif"));
		List<String> graphicFiles = files.stream()
				.filter(file -> fileGraphicExtention.contains(file.substring(file.indexOf("."), file.length())))
				.collect(Collectors.toList());
		return graphicFiles;
	}
}
