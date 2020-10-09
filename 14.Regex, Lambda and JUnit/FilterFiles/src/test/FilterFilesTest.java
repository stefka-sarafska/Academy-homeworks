package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import swift.acad.task.Task1_FilterFiles;

public class FilterFilesTest {
	@Test
	public void testFilterJpgFiles() {
		List<String> files = new ArrayList<String>(Arrays.asList("demo.txt", "project.jpg"));
		assertEquals(Arrays.asList("project.jpg"), Task1_FilterFiles.getGraphicFilesFromInput(files));
	}

	@Test
	public void testFilterPngFiles() {
		List<String> files = new ArrayList<String>(Arrays.asList("demo.txt", "project.java", "swift.png", "task.bat"));
		assertEquals(Arrays.asList("swift.png"), Task1_FilterFiles.getGraphicFilesFromInput(files));
	}

	@Test
	public void testFilterBmpFiles() {
		List<String> files = new ArrayList<String>(Arrays.asList("demo.txt", "project.java", "swift.bmp", "task.bat"));
		assertEquals(Arrays.asList("swift.bmp"), Task1_FilterFiles.getGraphicFilesFromInput(files));
	}

	@Test
	public void testFilterGifFiles() {
		List<String> files = new ArrayList<String>(Arrays.asList("demo.txt", "project.java", "swift.gif", "task.bat"));
		assertEquals(Arrays.asList("swift.gif"), Task1_FilterFiles.getGraphicFilesFromInput(files));
	}

}
