package education;

import java.time.LocalDate;

public class HigherEducation extends GradedEducation {
	private EducationDegree degree;

	public HigherEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName, EducationDegree degree, float finalGrade) {
		super(graduated, enrollmentDate, graduationDate, institutionName, degree, finalGrade);
		this.degree=degree;
	}

	@Override
	public String getDegree() {
		return degree.toString();
	}
	


}
