package bank.management;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String line = sp.nextLine();
		String[] input = line.split(" ");

		String command = input[0];
		while (!command.equals("END")) {
			if (command.equals("OPEN")) {
				Bank.openAccount(input[3], input[4], input[1], input[2]);
			} else if (command.equals("CLOSE")) {
				Bank.closeAccount(input[1], input[2]);
			} else if (command.equals("DEPOSIT")) {
				Bank.deposit(input[1], Double.parseDouble(input[2]));
			} else if (command.equals("WITHDRAW")) {
				Bank.withdraw(input[1], input[2], Double.parseDouble(input[3]));
			} else if (command.equals("TRANSFER")) {
				Bank.transfer(input[1], input[2], Double.parseDouble(input[3]), input[4]);
			}

			line = sp.nextLine();
			input = line.split(" ");
			command = input[0];
		}
		System.out.println(Bank.getAssets());
		Bank.printAccounts();
		sp.close();
	}
}
