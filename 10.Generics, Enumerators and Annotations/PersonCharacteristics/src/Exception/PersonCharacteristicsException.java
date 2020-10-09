package Exception;

public class PersonCharacteristicsException extends Exception{
	private String message;
	public PersonCharacteristicsException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}
	

}
