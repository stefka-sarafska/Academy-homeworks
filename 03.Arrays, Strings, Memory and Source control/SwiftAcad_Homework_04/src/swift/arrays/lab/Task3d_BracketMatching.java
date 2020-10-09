package swift.arrays.lab;

import java.util.Scanner;

public class Task3d_BracketMatching {
	public static void main(String[] args) {
		 Scanner sp = new Scanner(System.in);
	        String input = sp.nextLine();
	        char[] arr = input.toCharArray();
	        char[] openBracket = new char[arr.length];
	        int count = 0;

	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
	                openBracket[count] = arr[i];
	                count++;
	            } else if (arr[i] == ')') {
	                if (openBracket[count - 1] == '(') {
	                    openBracket[count - 1] = ' ';
	                    count--;
	                } else {
	                    break;
	                }
	            } else if (arr[i] == ']') {
	                if (openBracket[count - 1] == '[') {
	                    openBracket[count - 1] = ' ';
	                    count--;
	                } else {
	                    break;
	                }
	            } else if (arr[i] == '}') {
	                if (openBracket[count - 1] == '{') {
	                    openBracket[count - 1] = ' ';
	                    count--;
	                } else {
	                    break;
	                }
	            }
	        }
	        if (count == 0) {
	            System.out.println("true");
	        } else {
	            System.out.println("false");
	        }

	}

}
