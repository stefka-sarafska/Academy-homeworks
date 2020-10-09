package bank.management;

public class Bank {
	public static Account[] accounts = new Account[5];
	private static double assets;

	private static void updateAssets() {
		double accountsAsset = 0;
		for (Account acc : accounts) {
			if (acc != null) {
				accountsAsset += acc.getBalance();
			}
		}
		assets = accountsAsset;
	}

	private static int counter = 0;

	public static void openAccount(String name, String govId, String username, String password) {
		if (counter == accounts.length) {
			System.out.println("OPEN fail");
			return;
		} else {
			Credentials credentials = new Credentials(username, password);
			accounts[counter] = new Account(name, govId, credentials);
			counter++;
			System.out.println("OPEN success");
		}
	}

	public static void closeAccount(String username, String password) {
		Account acc = findAccountByUsername(username);
		if (acc == null || !password.equals(acc.getPassword())) {
			System.out.println("CLOSE fail");
			return;
		}
		acc = null;
		counter--;
		System.out.println("CLOSE success");
	}

	public static void deposit(String username, double amount) {
		Account acc = findAccountByUsername(username);
		if (acc == null || amount + acc.getBalance() < 0) {
			System.out.println("DEPOSIT fail");
			return;
		}
		acc.setBalance(acc.getBalance() + amount);
		updateAssets();
		System.out.println("DEPOSIT success");
	}

	public static void withdraw(String username, String password, double amount) {
		Account acc = findAccountByUsername(username);
		if (acc == null || !acc.getPassword().equals(password) || amount >= acc.getBalance()) {
			System.out.println("WITHDRAW fail");
			return;
		}
		acc.setBalance(acc.getBalance() - amount);
		updateAssets();
		System.out.println("WITHDRAW success");
	}

	public static void transfer(String username, String password, double amount, String recipient) {
		Account acc = findAccountByUsername(username);
		Account rec = findAccountByUsername(recipient);

		if (acc == null || rec == null || !acc.getPassword().equals(password) || amount >= acc.getBalance()) {
			System.out.println("TRANSFER fail");
			return;
		}
		acc.setBalance(acc.getBalance() - amount);
		rec.setBalance(rec.getBalance() + amount);
		System.out.println("TRANSFER success");
	}

	public static double getAssets() {
		return Bank.assets;
	}

	private static Account findAccountByUsername(String username) {
		for (Account account : accounts) {
			if (account != null && account.getUsername().equals(username)) {
				return account;
			}
		}
		return null;
	}

	public static void printAccounts() {
		for (Account ac : accounts) {
			if (ac != null) {
				System.out.printf("%s, %s, %.2f%n", ac.getName(), ac.getGovId(), ac.getBalance());
			}
		}
	}

}
