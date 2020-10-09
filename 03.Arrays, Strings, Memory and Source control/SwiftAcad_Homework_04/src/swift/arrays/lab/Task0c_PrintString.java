package swift.arrays.lab;

import java.util.Scanner;

public class Task0c_PrintString {
public static void main(String[] args) {
	Scanner sp = new Scanner(System.in);
	String input = sp.nextLine();
	
	for(int i =0; i<input.length();i++) {
		System.out.println(input.charAt(i));
	}
	
}
}
