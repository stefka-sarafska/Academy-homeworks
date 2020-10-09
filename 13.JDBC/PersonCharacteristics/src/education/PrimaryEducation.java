package education;

import java.time.LocalDate;

public class PrimaryEducation extends Education {
	private final static EducationDegree degree=EducationDegree.Primary;

	public PrimaryEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName) {
		super(graduated, enrollmentDate, graduationDate, institutionName, degree);
		
	}

	@Override
	public String getDegree() {
		return degree.toString();
	}

	@Override
	public boolean gotGraduated() {
		if (isGraduated()) {
			return true;
		} else {
			return false;
		}

	}

}
