import java.util.Scanner;

public class CalculatorMain {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String line = sp.nextLine();
		String[] input = line.split(" ");
		while (!(input[0].equals("END"))) {
			double firstNum = Double.parseDouble(input[1]);
			double secondNum = Double.parseDouble(input[2]);
			
         
			if (input[0].equals("SUM")) {
				System.out.printf("%.3f %n",  Calculator.sum(firstNum, secondNum));

			} else if (input[0].equals("SUB")) {
				
				System.out.printf("%.3f%n",Calculator.subtract(firstNum, secondNum));
			} else if (input[0].equals("MUL")) {
			System.out.printf("%.3f%n",Calculator.multiply(firstNum, secondNum));
			} else if (input[0].equals("DIV")) {
			System.out.printf("%.3f%n",Calculator.divide(firstNum, secondNum));
			} else if (input[0].equals("PER")) {
			System.out.printf("%.3f%n",Calculator.percentage(firstNum, secondNum));
			}

			line = sp.nextLine();
			input = line.split(" ");
		}
	}

}
