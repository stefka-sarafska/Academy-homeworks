package education;

import java.time.LocalDate;

public class SecondaryEducation extends GradedEducation{

	private String degree;

	public SecondaryEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName, float finalGrade) {
		super(graduated, enrollmentDate, graduationDate, institutionName, finalGrade);
		this.degree="secondary";
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
	
	

}
