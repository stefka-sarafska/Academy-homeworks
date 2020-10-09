
public class OldPasswordConflictException extends Exception {
	private String password;
	private String[] passwordArchive;
	
	public OldPasswordConflictException(String password,String[] passwordArchive) {
		this.password = password;
		this.passwordArchive=passwordArchive;
	}
	
	public String getMessage() {
		return "CHPASS failed [Password matches a recently used one:  " + getPasswordConflictIndex() + "]";
	}

	private int getPasswordConflictIndex() {
		int passIndex=0;
		for(int i=0;i<passwordArchive.length;i++) {
			if(passwordArchive[i]==null) {
				return i-passIndex-1;
			}else if(passwordArchive[i].equals(password)) {
				passIndex=i;
			}
		}
		return -11;
		
	}
}
