package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import swift.tasks.Task0c_IsCorrectSQLInsert;

public class IsCorrectSQLInsertTest {
	@Test
	public void testCorrectSQLWithUpperCase() {
		String input = "INSERT INTO tableName(name,salary) VALUES (name,salary);";
		boolean isCorrect = Task0c_IsCorrectSQLInsert.isCorrectSQLInsertQuery(input);
		assertTrue(isCorrect);
	}
	
	@Test
	public void testCorrectSQLWithLowerCase() {
		String input = "insert into tableName(name,salary) values (name,salary);";
		boolean isCorrect = Task0c_IsCorrectSQLInsert.isCorrectSQLInsertQuery(input);
		assertTrue(isCorrect);
	}
	
	@Test
	public void testCorrectSQLWithLowerCaseWithoutSpaceAfterValue() {
		String input = "insert into tableName(name,salary) values(name,salary);";
		boolean isCorrect = Task0c_IsCorrectSQLInsert.isCorrectSQLInsertQuery(input);
		assertTrue(isCorrect);
	}
	
	@Test
	public void testCorrectSQLWithLowerCaseWithSpaceAfterTableName() {
		String input = "insert into tableName (name,salary) values(name,salary);";
		boolean isCorrect = Task0c_IsCorrectSQLInsert.isCorrectSQLInsertQuery(input);
		assertTrue(isCorrect);
	}
	

	@Test
	public void testWrongSQLWithLowerCaseWithoutSpaceAfterInsert() {
		String input = "insertinto tableName(name,salary) values(name,salary);";
		boolean isCorrect = Task0c_IsCorrectSQLInsert.isCorrectSQLInsertQuery(input);
		assertEquals(false, isCorrect);
	}
	
	

}
