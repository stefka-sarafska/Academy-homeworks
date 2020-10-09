package swift.loops;

import java.util.Scanner;

public class Task3a_PrintSquare {
	public static void main(String[] args) {
		 Scanner sp = new Scanner(System.in);
	        final String SING = "*";
	        int n = sp.nextInt();
	        

	        for (int i = 0; i < n; i++) {
	            System.out.printf("%s  ",SING);
	        }
	        System.out.println();
	        for (int i = 0; i < n-1; i++) {
	            if (i==n-2){
	                System.out.printf("%s",SING);
	            }else {
	                System.out.print(SING);
	                for (int j = 0; j < n * 3-4 ; j++) {
	                    System.out.print(" ");
	                }
	                System.out.println(SING);
	            }

	        }
	        for (int i = 0; i < n-1; i++) {
	            System.out.printf("  %s",SING);

	        }

	}
}
