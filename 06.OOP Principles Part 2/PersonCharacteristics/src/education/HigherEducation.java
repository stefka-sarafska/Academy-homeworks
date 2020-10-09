package education;

import java.time.LocalDate;

public class HigherEducation extends GradedEducation{
private String degree;
public HigherEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName, float finalGrade) {
		super(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
	}

	@Override
	public String getDegree() {
		return degree;
	}

	@Override
	public boolean gotGraduated() {
		if(getFinalGrade()!=-1) {
			return true;
		}else {
			return false;
		}
	}
	public void setDegree(String degree) {
		this.degree=degree;
	}

}
