import java.util.Scanner;

import bank.accounts.BankAccount;
import bank.accounts.DepositAccount;
import bank.accounts.LoanAccount;
import bank.accounts.MortgageAccount;
import customers.CompanyCustomer;
import customers.Customer;
import customers.IndividualCustomer;

public class Task2_Bank {
	private static BankAccount[] accounts = new BankAccount[50];
	private static int counterForBankAccounts = 0;

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String line = sp.nextLine();
		String[] input = line.split(" ");
		String command = input[0];

		while (!"END".equals(command)) {

			if ("OPEN".equals(command)) {
				String typeOfAccount = input[3];
				String typeOfClient = input[2];
				openBankAccount(input, typeOfAccount, typeOfClient);
				System.out.println(BankAccount.ibanToString());
			} else if ("PUT".equals(command)) {
				BankAccount account = searchBankAccountByNameAndIban(accounts, input[1]);
				if (account != null) {
					account.depositingMoney(Double.parseDouble(input[2]));
				}

			} else if ("GET".equals(command)) {
				BankAccount account = searchBankAccountByNameAndIban(accounts, input[1]);
				if (account != null) {
					if (account instanceof DepositAccount) {
						DepositAccount deposit = (DepositAccount) account;
						deposit.withDrawMoney(Double.parseDouble(input[2]));
					}
				}

			} else if ("INFO".equals(command)) {
				BankAccount account = searchBankAccountByNameAndIban(accounts, input[1]);
				int monthsForInterenseRate = Integer.parseInt(input[2]);
				if (account != null) {
					double finalRate = 0;
					if (account instanceof LoanAccount) {
						if (account.getOwner() instanceof IndividualCustomer) {
							monthsForInterenseRate -= 3;
							finalRate = account.calculateInterestRate(monthsForInterenseRate);
						} else if (account.getOwner() instanceof CompanyCustomer) {
							monthsForInterenseRate -= 2;
							finalRate = account.calculateInterestRate(monthsForInterenseRate);
						}
					} else if (account instanceof MortgageAccount) {
						if (account.getOwner() instanceof IndividualCustomer) {
							monthsForInterenseRate -= 6;
							finalRate = account.calculateInterestRate(monthsForInterenseRate);
						} else if (account.getOwner() instanceof CompanyCustomer) {
							finalRate = account.calculateInterestRate(monthsForInterenseRate)
									- account.calculateInterestRate(12) / 2;
						}

					} else {
						finalRate = account.calculateInterestRate(monthsForInterenseRate);
					}
					System.out.println(finalRate);
				}
			}

			line = sp.nextLine();
			input = line.split(" ");
			command = input[0];
		}
	}

	private static BankAccount searchBankAccountByNameAndIban(BankAccount[] accounts, String name) {
		for (BankAccount b : accounts) {

			if (b != null) {
				String iban = b.getIban();
				if (name.equals(b.getNameOfCustomer()) || name.equals(iban)) {
					return b;
				}
			}
		}
		return null;

	}

	private static void openBankAccount(String[] input, String typeOfAccount, String typeOfClient) {
		if ("1".equals(typeOfAccount)) {
			if (openCustomerAccount(input, typeOfAccount, typeOfClient) != null) {
				Customer customer = openCustomerAccount(input, typeOfAccount, typeOfClient);
				accounts[counterForBankAccounts] = new DepositAccount(customer, Double.parseDouble(input[4]),
						Double.parseDouble(input[5]));
				counterForBankAccounts++;
			}
		} else if ("2".equals(typeOfAccount)) {
			if (openCustomerAccount(input, typeOfAccount, typeOfClient) != null) {
				Customer customer = openCustomerAccount(input, typeOfAccount, typeOfClient);
				accounts[counterForBankAccounts] = new LoanAccount(customer, Double.parseDouble(input[4]),
						Double.parseDouble(input[5]));
				counterForBankAccounts++;
			}
		} else if ("3".equals(typeOfAccount)) {
			if (openCustomerAccount(input, typeOfAccount, typeOfClient) != null) {
				Customer customer = openCustomerAccount(input, typeOfAccount, typeOfClient);
				accounts[counterForBankAccounts] = new MortgageAccount(customer, Double.parseDouble(input[4]),
						Double.parseDouble(input[5]));
				counterForBankAccounts++;
			}
		}
	}

	private static Customer openCustomerAccount(String[] input, String typeOfAccount, String typeOfClient) {
		if ("1".equals(typeOfClient)) {
			IndividualCustomer customer = new IndividualCustomer(input[1]);
			return customer;
		} else if ("2".equals(typeOfClient)) {
			CompanyCustomer customer = new CompanyCustomer(input[1]);
			return customer;

		}
		return null;
	}

}
