package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import swift.tasks.Task0b_FindFunnyCharacters;

public class FindFunnyCharactersTest {
	@Test
	public void testFunnyCharactersWithManyCharacters() {
		assertEquals(Arrays.asList(" ", "т", "е", " ", ",", ".", "?"),
				Task0b_FindFunnyCharacters.findAndPrintFunnyCharacters("ab те ,.?80"));
	}
	@Test
	public void testFunnyCharactersWithCyrillicAlphabet() {
		assertEquals(Arrays.asList("т","Н","р","л"), Task0b_FindFunnyCharacters.findAndPrintFunnyCharacters("sdgtfvтabvdНрл"));
	}
	@Test
	public void testFunnyCharactersWithPunctuationMarks() {
		assertEquals(Arrays.asList(",",".","?"), Task0b_FindFunnyCharacters.findAndPrintFunnyCharacters("fvnslfv,njd80.?"));
	}
	@Test
	public void testFunnyCharactersWithSpaceSign() {
		assertEquals(Arrays.asList(" "," "), Task0b_FindFunnyCharacters.findAndPrintFunnyCharacters("one two three"));
	}
	@Test
	public void testFunnyCharactersWithSpecificSign() {
		assertEquals(Arrays.asList("§"), Task0b_FindFunnyCharacters.findAndPrintFunnyCharacters("one§two"));
	}
	
}
