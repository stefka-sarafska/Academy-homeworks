package education;

import java.time.LocalDate;

public class PrimaryEducation extends Education {
private String degree;
public PrimaryEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName) {
		super(graduated, enrollmentDate, graduationDate, institutionName);
		this.degree="primary";
	}

@Override
public String getDegree() {
	return degree;
	
}

@Override
public boolean gotGraduated() {
	if(isGraduated()) {
		return true;
	}else {
		return false;
	}
	
}



	
}
