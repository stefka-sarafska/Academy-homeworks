public class Credentials {

	private String username;
	private String password;
	private String[] passwordArchive = new String[100];
	private int passCount = 0;

	public Credentials(String name, String pass) {
		username = name;
		password = pass;
		passwordArchive[passCount] = pass;
		passCount++;
	}

	public void changePass(String oldPassword, String newPassword) throws FailException, OldPasswordConflictException {
		if (newPassword != null && !isInOldPasswords(newPassword) && login(oldPassword)) {
			setPassword(newPassword);
			passwordArchive[passCount] = newPassword;
			passCount++;
		} else {
			throw new FailException("CHPASS");
		}
	}

	public boolean login(String password) {
		if (password != null && password.equals(this.password)) {
			return true;
		}
		return false;
	}

	public boolean isInOldPasswords(String password) throws OldPasswordConflictException {
		for (String oldPassword : passwordArchive) {
			if (oldPassword != null && oldPassword.equals(password)) {
				throw new OldPasswordConflictException(password, passwordArchive);
			}
		}
		return false;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}