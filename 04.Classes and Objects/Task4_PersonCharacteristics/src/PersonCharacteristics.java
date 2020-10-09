import java.util.Scanner;

public class PersonCharacteristics {
	String firstName;
	String lastName;
	String gender;
	short birthYear;
	double weight;
	short height;
	String profession;
	double[] grades;

	public PersonCharacteristics(String firstName, String lastName, String gender, short birthYear, double weight,
                                 short height, String profession, double[] grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthYear = birthYear;
		this.weight = weight;
		this.high = height;
		this.profession = profession;
		this.grades = grades;
	}

	public int getAge(int birthYear) {
		return 2020 - birthYear;
	}

	public double getAvgGrade(double[] grades) {

		double avgGrade = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 2 && grades[i] <= 6) {
				avgGrade += grades[i];
			} else {
				System.out.println("Invalid grade.");
			}
		}
		avgGrade = avgGrade / 4;
		return avgGrade;
	}

	public void showInfoAboutPerson(String gender, int age, double avgGrade) {
		if (gender.equals("M")) {
			System.out.printf(
					"%s %s is %d years old. He was born in %d. His weight is %.2f and he is %d cm tall. He is a %s with an average grade of %.3f.",
					firstName, lastName, age, birthYear, weight, high, profession, avgGrade);

			if (age < 18) {
				System.out.printf("%s %s is under-aged.", firstName, lastName);

			}
			System.out.println();
		} else if (gender.equals("F")) {
			System.out.printf(
					"%s %s is %d years old.She was born in %d. Her weight is %.1f and she is %d cm tall. She is a %s with an average grade of %.3f.",
					firstName, lastName, age, birthYear, weight, high, profession, avgGrade);

			if (age < 18) {
				System.out.printf("[%s %s is under-aged.]", firstName, lastName);

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = Integer.parseInt(sp.nextLine());
		PersonCharacteristics[] people = new PersonCharacteristics[n];

		for (int i = 0; i < n; i++) {
			String input = sp.nextLine();
			String[] line = input.split(", ");
			String firstName = line[0];
			String lastName = line[1];
			String gender = line[2];
			short birthYear = Short.parseShort(line[3]);
			double weight = Double.parseDouble(line[4]);
			short height = Short.parseShort(line[5]);
			String profession = line[6];
			double grade1 = Double.parseDouble(line[7]);
			double grade2 = Double.parseDouble(line[8]);
			double grade3 = Double.parseDouble(line[9]);
			double grade4 = Double.parseDouble(line[10]);

			double[] grades = new double[] { grade1, grade2, grade3, grade4 };

			people[i] = new PersonCharacteristics(firstName, lastName, gender, birthYear, weight, height, profession,
					grades);
		}
		for (PersonCharacteristics p : people) {
			int age = p.getAge(p.birthYear);
			double avgGrades = p.getAvgGrade(p.grades);
			p.showInfoAboutPerson(p.gender, age, avgGrades);

		}
	}

}
