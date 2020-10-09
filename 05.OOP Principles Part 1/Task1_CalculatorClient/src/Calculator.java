
public class Calculator {
	
	public static double sum(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double divide(double a, double b) {
		double result = 0;
		if (b != 0) {
			result = a / b;
		} else {
			System.out.println("Can't divide by 0");
		}
		return result;
	}

	public static double percentage(double a, double b) {
		return a/100*b;
	}

}
