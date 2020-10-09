package swift.arrays.lab;

import java.util.Scanner;

public class Task4_PersonCharacteristics {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		sp.nextLine();
		

		for (int i = 0; i < n; i++) {
			String line=sp.nextLine();
			String[]array=line.split(";");
			
			String firstName = array[0];
			String lastName = array[1];
			String gender = array[2];
			
			short birthYear = Short.parseShort(array[3]);
			double weight = Double.parseDouble(array[4]);
			short height = Short.parseShort(array[5]);
			String profession = array[6];
			
			double grade1=Double.parseDouble(array[7]);
			double grade2=Double.parseDouble(array[8]);
			double grade3=Double.parseDouble(array[9]);
			double grade4=Double.parseDouble(array[10]);
			

			double[] grades = new double[]{grade1,grade2,grade3,grade4};

			double avgGrade = 0;
			for (int j = 0; j < grades.length; j++) {
				if (grades[i] >= 2 && grades[i] <= 6) {
					avgGrade += grades[i];
				} else {
					System.out.println("Invalid grade.");
				}
			}
			avgGrade = avgGrade / 4;
			int age = 2020 - birthYear;
			if (gender.equals("M")) {
				System.out.printf("%s %s is %d years old. He was born in %d. His weight is %.2f and he is %d cm tall. He is a %s with an average grade of %.3f.",
						firstName, lastName, age, birthYear, weight, height, profession,avgGrade);

				if (age < 18) {
					System.out.printf("%s %s is under-aged.", firstName, lastName);

				}
				System.out.println();
			} else if (gender.equals("F")) {
				System.out.printf(
						"%s %s is %d years old.She was born in %d. Her weight is %.1f and she is %d cm tall. She is a %s with an average grade of %.3f.",
						firstName, lastName, age, birthYear, weight, height, profession,avgGrade);

				if (age < 18) {
					System.out.printf("[%s %s is under-aged.]", firstName, lastName);

				}
				System.out.println();
			}
		}

	}

}
