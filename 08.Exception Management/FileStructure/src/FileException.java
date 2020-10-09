
public class FileException extends Exception{
	private String exMsg;
	private int exceptionLine;
	public FileException(String exMsg,int exceptionLine) {
		this.exMsg=exMsg;
		this.exceptionLine=exceptionLine;
	}
	public FileException(String exMsg) {
		this.exMsg=exMsg;
		this.exceptionLine=exceptionLine;
	}
	
	
public String getMessage() {
	return exceptionLine+" - " +exMsg;
}
}
