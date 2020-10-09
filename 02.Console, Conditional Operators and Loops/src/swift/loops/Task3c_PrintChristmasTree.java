package swift.loops;

import java.util.Scanner;

public class Task3c_PrintChristmasTree {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
        final String SING = "*";
        int n = sp.nextInt();
        int counter = 1;
        int countLines = 0;
        int middleOfSnowflakesInLastLineOfTree = ((n - 2) * 2 - 1) / 2;


        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < middleOfSnowflakesInLastLineOfTree; j++) {
                System.out.print(" ");

            }

            for (int j = 0; j < n - 2; j++) {

                for (int k = 0; k < counter; k++) {
                    System.out.printf("%s", SING);
                }
                System.out.println();
                counter += 2;
                countLines++;
                for (int p = 0; p < middleOfSnowflakesInLastLineOfTree - countLines; p++) {
                    System.out.print(" ");

                }
            }
            for (int j = 0; j < middleOfSnowflakesInLastLineOfTree; j++) {
                System.out.print(" ");

            }
            System.out.printf("%s", SING);
            System.out.println();
            for (int p = 0; p < middleOfSnowflakesInLastLineOfTree - 1; p++) {
                System.out.print(" ");

            }
            System.out.printf("%s%s%s", SING, SING, SING);

            break;


        }
	}

}
