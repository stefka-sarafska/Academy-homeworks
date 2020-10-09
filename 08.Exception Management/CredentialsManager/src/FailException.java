
public class FailException extends Exception{
	
	private String command;
	
	public FailException(String command) {
		this.command = command;
	}
	
	public String getMessage() {
		return String.format("%s %s", this.command, "failed");
	}

}
