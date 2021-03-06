package education;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Education{
	private boolean graduated;
	private EducationDegree degree;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;

	public Education(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			EducationDegree degree) {
		this.graduated = graduated;
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.institutionName = institutionName;
		this.degree = degree;
	}

	public abstract String getDegree();

	public abstract boolean gotGraduated();

	public boolean isGraduated() {
		return graduated;
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

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

}