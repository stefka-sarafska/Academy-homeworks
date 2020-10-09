package bank.management;


public class Credentials {
	private String username;
	private String password;

	public Credentials(String name, String pass) {
		username = name;
		password = pass;
	}

	public static String changePass(String passToChange, String name, String newPass, String[] oldPasswords,Credentials[] users) {
		String result = " ";
		for (Credentials p : users) {
			if (p == null) {
				break;
			}
			if ((p.getUsername().equals(name)) && (p.getPassword().equals(passToChange))) {
				for (String pass : oldPasswords) {
					if (pass == null) {
						break;
					}
					if (!(pass.equals(newPass))) {
						result = "success";

					} else {
						result = "fail";
						break;
					}
				}
			}
		}
		return result;
	}

	public static String authPass(Credentials[] users, String pass, String name) {
		String result = " ";

		for (Credentials p : users) {
			if (p == null) {
				break;
			}
			if (p.getUsername().equals(name) && p.getPassword().equals(pass)) {
				result = "seccess";
			} else {
				result = "fail";
			}
		}
		return result;
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
