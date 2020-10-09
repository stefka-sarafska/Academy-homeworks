package swift.loops;

import java.util.Scanner;

public class Task1e_IsPrime {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int number = sp.nextInt();
		boolean isPrime = false;

		for (int i = 2; i <= number/2; i++) {
			if (number % i == 0) {
				 isPrime = true;
	                break;
			}

		}
		if(!isPrime) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}

}
