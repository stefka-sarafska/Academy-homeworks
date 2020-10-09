package education;

public enum EducationDegree {
	None("none"), Primary("primary"), Secondary("secondary"), Bachelor("bachelor"), Master("master"),
	Doctorate("doctorate");

	private String degree;

	private EducationDegree(String degree) {
		this.degree = degree;
	}

	public String toString() {
		return degree;
	}

}
