package swift.loops;

import java.util.Scanner;

public class Task4d_SumOfNumbersInString {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String sentence = sp.nextLine();
		String[] parts = sentence.split(" ");
		int sum=0;
		
		for(int i=0; i<parts.length;i++) {
			if(parts[i].matches("[0-9]+")){
				System.out.println(parts[i]);
				sum+=Integer.parseInt(parts[i]);
			}
		}
		System.out.println(sum);

	}

}
