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

	public boolean changePass(String oldPassword, String newPassword) {
		if (newPassword != null && !isInOldPasswords(newPassword) && login(oldPassword)) {
			setPassword(newPassword);
			passwordArchive[passCount] = newPassword;
			passCount++;
			return true;
		}
		return false;
	}

	public boolean login(String password) {
		if (password != null && password.equals(this.password)) {
			return true;
		}
		return false;
	}
	
	private boolean isInOldPasswords(String password) {
		for (String oldPassword : passwordArchive) {
			if (oldPassword != null && oldPassword.equals(password)) {
				return true;
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
