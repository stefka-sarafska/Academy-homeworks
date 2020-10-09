import java.util.Scanner;

public class CalculateDegreeOfNumber {
	public static void main(String[] args) {
		Scanner sp=new Scanner(System.in);
		int number=sp.nextInt();
		int degreesOfNumber=sp.nextInt();
		System.out.println(calculateDegreesOfNumber(number, degreesOfNumber));
	}
	private static int calculateDegreesOfNumber(int number, int degreesOfNumber) {
		if(degreesOfNumber==0) {
			return 1;
		}
		return number*calculateDegreesOfNumber(number, degreesOfNumber-1);
		
		
	}

}
