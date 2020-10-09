package swift.arrays.lab;

import java.util.Scanner;

public class Task0b_ReadArray {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n=sp.nextInt();
		int[] array=new int[n];
		for(int i =0; i<array.length;i++) {
			int number=sp.nextInt();
			array[i]=number;
		}
		for(int i=0;i<array.length;i++) {
			if(i==array.length-1) {
				System.out.printf("%s",array[i]);
			}else {
				System.out.printf("%s, ",array[i]);
			}
		}
	}

}
