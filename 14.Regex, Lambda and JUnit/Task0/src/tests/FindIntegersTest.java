package tests;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import swift.tasks.Task0a_FindIntegers;

public class FindIntegersTest {
	
	@Test
	public void testFindPositiveAndNegativeNumbers() {
		assertEquals(Arrays.asList("1", "2", "3", "-10", "-5", "2", "4"), Task0a_FindIntegers.findAndPrintIntegers("1 and 2 and 3 -10 -5 2,4"));
	}

}
