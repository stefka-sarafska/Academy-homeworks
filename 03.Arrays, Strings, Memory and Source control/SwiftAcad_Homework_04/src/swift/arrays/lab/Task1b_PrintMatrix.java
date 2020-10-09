package swift.arrays.lab;

import java.util.Scanner;

public class Task1b_PrintMatrix {
	public static void main(String[] args) {

		Scanner sp = new Scanner(System.in);
	    int n = sp.nextInt();
	    int[][] array = new int[n][n];

	    int counter=1;
	    for (int i = 0; i < array.length; i++) {
	    	if(i%2==0||i==0) {
	    		for (int j = 0; j < array[i].length; j++) {
		            array[j][i] = counter;
		          	            counter++;

		        }
	    	}else {
	    		for (int j = array[i].length-1; j >= 0; j--) {
		            array[j][i] = counter;
		          	            counter++;

		        }
	    	}
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    for (int i = 0; i < array.length; i++) {
	        for (int j = 0; j < array[i].length; j++) {

	            System.out.print(array[i][j]);
	            System.out.print("\t");

	            if (j == n-1) {
	                System.out.println();

	            }
	        }
	    }
	}
}
