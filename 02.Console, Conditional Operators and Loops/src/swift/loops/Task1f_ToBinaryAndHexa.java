package swift.loops;

import java.util.Scanner;

public class Task1f_ToBinaryAndHexa {
	public static void main(String[] args) {
		  Scanner sp = new Scanner(System.in);

	        double decimalNumberForBinarySystem = sp.nextDouble();
	        int decimalNumberForHexadecimalSystem = (int) decimalNumberForBinarySystem;

	        while (decimalNumberForBinarySystem >= 1) {
	            if (decimalNumberForBinarySystem % 2 == 1) {
	                System.out.printf("%d", 1);
	                decimalNumberForBinarySystem = Math.floor(decimalNumberForBinarySystem / 2);
	            } else {
	                System.out.printf("%d", 0);
	                decimalNumberForBinarySystem = Math.floor(decimalNumberForBinarySystem / 2);
	            }
	        }
	        System.out.println();
	        int i = 15;
	        String[] array = new String[i + 1];
	        while (decimalNumberForHexadecimalSystem > 0) {
	            double decNumber = decimalNumberForHexadecimalSystem % 16;
	            decimalNumberForHexadecimalSystem /= 16;
	            if (decNumber == 15) {
	                array[i] = "F";
	            } else if (decNumber == 14) {
	                array[i] = "E";
	            } else if (decNumber == 13) {
	                array[i] = "D";
	            } else if (decNumber == 12) {
	                array[i] = "C";
	            } else if (decNumber == 11) {
	                array[i] = "B";
	            } else if (decNumber == 10) {
	                array[i] = "A";
	            } else if (decNumber <= 9) {
	                array[i] = String.valueOf((int) decNumber);
	            }
	            
	            i--;
	        }
	        for (String num : array) {
	            if (num != null) {
	                System.out.printf("%s", num);
	            }
	        }
	}

}
