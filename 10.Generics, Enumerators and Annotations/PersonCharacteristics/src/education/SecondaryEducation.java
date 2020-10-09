package education;

import java.time.LocalDate;

public class SecondaryEducation extends GradedEducation{

	private final static EducationDegree degree=EducationDegree.Secondary;

	public SecondaryEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName, float finalGrade) {
		super(graduated, enrollmentDate, graduationDate, institutionName, degree,finalGrade);
	}

	@Override
	public String getDegree() {
		return degree.toString();
		
	}
}
