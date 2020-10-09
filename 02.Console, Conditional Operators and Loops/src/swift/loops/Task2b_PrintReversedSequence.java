package swift.loops;

import java.util.Scanner;

public class Task2b_PrintReversedSequence {
	public static void main(String[] args) {
		
		Scanner sp = new Scanner(System.in);
		
		int numbersCounter = sp.nextInt();
		int[] arrayOfNumbers = new int[numbersCounter];
		
		for(int i =0; i<numbersCounter; i++) {
			int number = sp.nextInt();
			arrayOfNumbers[i]=number;
		}
		
		for(int i=arrayOfNumbers.length-1; i>=0; i--) {
			System.out.printf("%d ",arrayOfNumbers[i]);
		}
		
		
	}

}
