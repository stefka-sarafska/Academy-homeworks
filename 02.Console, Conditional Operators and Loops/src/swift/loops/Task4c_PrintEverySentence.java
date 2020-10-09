package swift.loops;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task4c_PrintEverySentence {
	public static void main(String[] args) {
		
	
	 Scanner sp = new Scanner(System.in);
     String sentence = sp.nextLine();
          String[] parts = sentence.split("\\?|\\.|\\!");
     
     for(int i=0;i<parts.length;i++) {
    	 System.out.println(parts[i]);
     }
     
     
     
     
	}
}
