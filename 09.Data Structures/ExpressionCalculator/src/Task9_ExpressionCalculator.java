import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task9_ExpressionCalculator {
	private static final List<String> mathematicalSigns = new LinkedList<String>(
			Arrays.asList("*", "/", "+", "-", "^"));
	private static List<String> expression = new LinkedList<String>();

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String[] line = sp.nextLine().split(" ");
		addingExpressionToCalculateByInput(line);
		printExpresionSum();
		sp.close();

	}

	private static void addingExpressionToCalculateByInput(String[] line) {
		for (String element : line) {
			expression.add(element);
		}
	}

	// this method call others methods by priority
	private static void printExpresionSum() {
		calculateInScope();
		calculateComplexMathematicalOperations();
		double finalSum = calculateAdditionAndSubtraction();
		System.out.println(finalSum);
	}

	private static void calculateInScope() {
		for (int i = 0; i < expression.size(); i++) {
			String element = expression.get(i);
			if (element.equals("(")) {
				expression.remove(element);
				expression.add(i, String.valueOf(calculateInScope(expression.subList(i, expression.indexOf(")")))));
				i = -1;
			}
			if (element.equals(")")) {
				expression.remove(element);
			}
		}
	}

	private static void calculateComplexMathematicalOperations() {
		for (int i = 0; i < expression.size(); i++) {
			String element = expression.get(i);
			if (element.equals("*")) {

				expression.remove(element);
				expression.add(i - 1,
						String.valueOf(calculateSumByMathematicalSign("*", expression.subList(i - 1, i + 1))));
				i = -1;

			} else if (element.equals("/")) {

				expression.remove(element);
				expression.add(i - 1,
						String.valueOf(calculateSumByMathematicalSign("/", expression.subList(i - 1, i + 1))));
				i = -1;

			} else if (element.equals("^")) {
				expression.remove(element);
				expression.add(i - 1,
						String.valueOf(calculateSumByMathematicalSign("^", expression.subList(i - 1, i + 1))));
				i = -1;
			}
		}
	}

	private static double calculateAdditionAndSubtraction() {
		double finalSum = 0;
		for (int i = 0; i < expression.size(); i++) {
			String element = expression.get(i);

			if (element.equals("+")) {
				expression.remove(element);
				expression.add(i - 1,
						String.valueOf(calculateSumByMathematicalSign("+", expression.subList(i - 1, i + 1))));
				i = -1;
			} else if (element.equals("-")) {
				expression.remove(element);
				expression.add(i - 1,
						String.valueOf(calculateSumByMathematicalSign("-", expression.subList(i - 1, i + 1))));
				i = -1;
			} else if (!element.equals(")") && !element.equals("(")) {
				finalSum = Double.parseDouble(element);
			}
		}
		return finalSum;
	}

	private static double calculateSumByMathematicalSign(String sign, List<String> expression) {
		double sum = 0;
		if (sign.equals("*")) {
			sum = Double.parseDouble(expression.get(0)) * Double.parseDouble(expression.get(1));
		} else if (sign.equals("/")) {
			sum = Double.parseDouble(expression.get(0)) / Double.parseDouble(expression.get(1));
		} else if (sign.equals("^")) {
			sum = Math.pow(Double.parseDouble(expression.get(0)), Double.parseDouble(expression.get(1)));
		} else if (sign.equals("+")) {
			sum = Double.parseDouble(expression.get(0)) + Double.parseDouble(expression.get(1));
		} else if (sign.equals("-")) {
			sum = Double.parseDouble(expression.get(0)) - Double.parseDouble(expression.get(1));
		}
		expression.remove(0);
		expression.remove(0);
		return sum;
	}

	private static double calculateInScope(List<String> expression) {
		double sumInScope = 0;
		for (int i = 0; i < expression.size(); i++) {
			String element = expression.get(i);
			if (!element.equals(")")) {
				if (!mathematicalSigns.contains(element)) {
					sumInScope += Double.parseDouble(element);
					expression.remove(i);
					i--;
				} else {
					if (element.equals("+")) {
						sumInScope += Double.parseDouble(expression.get(i + 1));
						expression.remove(i);
						expression.remove(i);
					} else if (element.equals("-")) {
						sumInScope -= Double.parseDouble(expression.get(i + 1));
						expression.remove(i);
						expression.remove(i);
					} else if (element.equals("*")) {
						sumInScope *= Double.parseDouble(expression.get(i + 1));
						expression.remove(i);
						expression.remove(i);
					} else if (element.equals("/")) {
						sumInScope /= Double.parseDouble(expression.get(i + 1));
						expression.remove(i);
						expression.remove(i);
					} else if (element.equals("^")) {
						Math.pow(sumInScope, Double.parseDouble(expression.get(i + 1)));
						expression.remove(i);
						expression.remove(i);
					}
					i--;
				}
			} else {
				expression.remove(")");
				break;
			}
		}

		return sumInScope;
	}

}
