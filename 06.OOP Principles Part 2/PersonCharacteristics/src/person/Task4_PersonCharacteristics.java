package person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import education.Education;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;

public class Task4_PersonCharacteristics {
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
	private static Person[] people;

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = Integer.parseInt(sp.nextLine());

		people = new Person[n];

		for (int i = 0; i < n; i++) {
			String line = sp.nextLine();
			String[] input = line.split(";");
			LocalDate birthDate = LocalDate.parse(input[4], formatter);
			String codeForEducation=input[5];
			LocalDate enrollmentDate = LocalDate.parse(input[7], formatter);
			LocalDate graduationDate = LocalDate.parse(input[8], formatter);
			if(input.length>9) {
			if(graduationDate.isBefore(LocalDate.now())) {
				float finalGrade=Float.parseFloat(input[9]);
				boolean graduated=true;
				if("P".equals(codeForEducation)) {
					PrimaryEducation p=new PrimaryEducation(graduated, enrollmentDate, graduationDate, input[6]);
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, p);				
				}else if("S".equals(codeForEducation)) {
					SecondaryEducation s=new SecondaryEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, s);					
				}else if("B".equals(codeForEducation)) {
					HigherEducation h= new HigherEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					h.setDegree("bachelor");
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, h);
				}else if("M".equals(codeForEducation)) {
					HigherEducation h=new HigherEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					h.setDegree("master");
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, h);
				}else if("D".equals(codeForEducation)) {
					HigherEducation h=new HigherEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					h.setDegree("doctor");
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, h);					
				}
			}}else {
				float finalGrade=0;
				boolean graduated=false;
				if("P".equals(codeForEducation)) {
					PrimaryEducation p=new PrimaryEducation(graduated, enrollmentDate, graduationDate, input[6]);
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, p);				
				}else if("S".equals(codeForEducation)) {
					SecondaryEducation s=new SecondaryEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, s);					
				}else if("B".equals(codeForEducation)) {
					HigherEducation h= new HigherEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					h.setDegree("bachelor");
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, h);
				}else if("M".equals(codeForEducation)) {
					HigherEducation h=new HigherEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					h.setDegree("master");
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, h);
				}else if("D".equals(codeForEducation)) {
					HigherEducation h=new HigherEducation(graduated, enrollmentDate, graduationDate, input[6], finalGrade);
					h.setDegree("doctor");
					people[i]=new Person(input[0], input[1], input[2], Integer.parseInt(input[3]), birthDate, h);					
				}
			}
			
		

	}
		printPeopleInfo(people);
		}
	private static void printPeopleInfo(Person[] people) {
		for (Person p : people) {
			p.showInfoAboutPerson();
		}
	}
}
