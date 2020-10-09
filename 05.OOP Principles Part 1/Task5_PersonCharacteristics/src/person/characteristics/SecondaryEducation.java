package person.characteristics;

import java.time.LocalDate;

public class SecondaryEducation {
	private double finalGrade;
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;

	public SecondaryEducation(String institution, LocalDate enroll, LocalDate graduation) {
		this.institutionName = institution;
		this.enrollmentDate = enroll;
		this.graduationDate = graduation;
	}

	public SecondaryEducation(String institution, LocalDate enroll, LocalDate graduation, double finalGrade) {
		this(institution, enroll, graduation);
		setFinalGrade(finalGrade);
	}
	
	public void setFinalGrade(double finalGrade) {
		if(finalGrade >= 2 && finalGrade <= 6) {
			this.finalGrade = finalGrade;
			if(finalGrade>=3) {
				this.graduated = true;
			}else {
				this.graduated = false;
			}
		} else {
			this.finalGrade=0;
		}
	}
	
	public double getFinalGrade() {
		if (finalGrade != 0) {
			return finalGrade;
		} else {
			return -1;
		}
	}
	
	public boolean isGraduated() {
		return this.graduated;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}

}
