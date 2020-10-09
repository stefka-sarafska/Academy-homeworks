import java.util.Scanner;

public class CredentialsManagerMain {
	private static Credentials[] users = new Credentials[200];
	private static int counter = 0;

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String line = sp.nextLine();
		String[] input = line.split(" ");
		String command = input[0];

		while (!(command.equals("END"))) {
			try {
				if (command.equals("ENROLL")) {
					enrollCredentials(input);

				} else if (command.equals("CHPASS")) {
					changingPassword(input);
				} else if (command.equals("AUTH")) {
					authCurrentPassword(input);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.printf("%s %s%n", command, "fail");
				System.out.println("You tried to enroll element which does not exist" + e.getMessage());
			} catch (FailException e) {
				System.out.println(e.getMessage());
			} catch (OldPasswordConflictException e) {
				System.out.println(e.getMessage());
			}
			line = sp.nextLine();
			input = line.split(" ");
			command = input[0];
		}
		sp.close();
	}

	private static void enrollCredentials(String[] input) {
		users[counter] = new Credentials(input[1], input[2]);
		counter++;
		System.out.println("ENROLL success");
	}

	private static void changingPassword(String[] input)
			throws FailException, OldPasswordConflictException {
		Credentials user = findCredentialsByUsername(input[1]);
		if (user != null) {
			user.changePass(input[2], input[3]);
			System.out.println("CHPASS success");
		} else {
			throw new FailException("CHPASS");
		}

	}

	private static void authCurrentPassword(String[] input) throws FailException {
		Credentials user = findCredentialsByUsername(input[1]);
		if (user != null) {
			if (user.login(input[2])) {
				System.out.println("AUTH success");
			} else {
				throw new FailException("AUTH");
			}
		} else {
			throw new FailException("AUTH");
		}

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