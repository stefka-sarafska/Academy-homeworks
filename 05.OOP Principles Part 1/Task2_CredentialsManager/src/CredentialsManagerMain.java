import java.util.Scanner;

public class CredentialsManagerMain {
	private static Credentials[] users = new Credentials[200];

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String line = sp.nextLine();
		String[] input = line.split(" ");
		String command = input[0];
		int counter = 0;

		while (!(command.equals("END"))) {
			if (command.equals("ENROLL")) {
				if (counter == users.length) {
					System.out.printf("%s %s%n", command, "fail");
				} else {
					users[counter] = new Credentials(input[1], input[2]);
					counter++;
					System.out.printf("%s %s%n", command, "success");
				}
			} else if (command.equals("CHPASS")) {
				Credentials user = findCredentialsByUsername(input[1]);
				if (user != null && user.changePass(input[2], input[3])) {
					System.out.printf("%s %s%n", command, "success");
				} else {
					System.out.printf("%s %s%n", command, "fail");
				}
			} else if (command.equals("AUTH")) {
				Credentials user = findCredentialsByUsername(input[1]);
				if (user != null && user.login(input[2])) {
					System.out.printf("%s %s%n", command, "success");
				} else {
					System.out.printf("%s %s%n", command, "fail");
				}
			}
			line = sp.nextLine();
			input = line.split(" ");
			command = input[0];
		}
		sp.close();
	}

	private static Credentials findCredentialsByUsername(String username) {
		for (Credentials credentials : users) {
			if (credentials != null && credentials.getUsername().equals(username)) {
				return credentials;
			}
		}
		return null;
	}
}
