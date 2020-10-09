package person;

public enum Gender  {
	Male("M"), Female("F");

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
