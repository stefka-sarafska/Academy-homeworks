package Exception;

public class DALException extends Exception {
	private String message;

	public DALException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
