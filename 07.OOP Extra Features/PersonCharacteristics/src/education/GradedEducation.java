package education;

import java.time.LocalDate;

public abstract class GradedEducation extends Education {
	private float finalGrade;

	public GradedEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName, float finalGrade) {
		super(graduated, enrollmentDate, graduationDate, institutionName);
		this.finalGrade = finalGrade;
	}

	public float getFinalGrade() {
		if (!gotGraduated(finalGrade)) {
			return -1;
		} else {
			return this.finalGrade;
		}
	}

	public boolean gotGraduated(float finalGrade) {
		if (this.finalGrade >= 3 && this.finalGrade <= 6) {
			return true;
		} else {
			return false;
		}
	}

}
