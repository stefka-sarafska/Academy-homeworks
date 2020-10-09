package swift.loops;

import java.util.Scanner;

public class Task2c_PrintOnlyEvenNumbers {
	public static void main(String[] args) {
		Scanner sp= new Scanner(System.in);
		
		int numbersCounter = sp.nextInt();
		
		for(int i =0; i < numbersCounter; i++) {
			int number = sp.nextInt();
			if(number%2==0) {
				System.out.printf("%d ",number);
			}
		}
	}

}
