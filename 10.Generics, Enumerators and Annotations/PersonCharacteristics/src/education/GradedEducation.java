package education;

import java.time.LocalDate;

import Exception.PersonCharacteristicsException;

public abstract class GradedEducation extends Education {
	private float finalGrade;

	public GradedEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName, EducationDegree degree,float finalGrade) {
		super(graduated, enrollmentDate, graduationDate, institutionName,degree);
		this.finalGrade = finalGrade;
	}

	public float getFinalGrade() throws PersonCharacteristicsException {
		if (!gotGraduated()) {
			throw new PersonCharacteristicsException("No final grade can be provided before graduation.");
		} else {
			return this.finalGrade;
		}
	}
   
	@Override
	public boolean gotGraduated() {
		if (this.finalGrade >= 2 && this.finalGrade <= 6) {
			return true;
		} else {
			return false;
		}
	}

}
