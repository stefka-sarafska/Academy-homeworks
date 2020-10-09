package swift.arrays.lab;

import java.util.Scanner;

public class Task3a_IsPalindrome {
public static void main(String[] args) {
	Scanner sp=new Scanner(System.in);
	String word = sp.nextLine();
	char[] arr = word.toCharArray();
	
	boolean isPalindrome =false;
	for(int i =0;i<arr.length;i++) {
		for(int j=arr.length-1;j>=0;j--) {
			if(arr[i]==arr[j]) {
				isPalindrome=true;
			}else {
				isPalindrome=false;
				break;
			}
		}
	}
	if(isPalindrome) {
		System.out.println(isPalindrome);
	}else {
		System.out.println(isPalindrome);
	}
}
}
