package bank.accounts;

import customers.Customer;

public class BankAccount {
	public static int IBAN;
	public String iban;
	private Customer owner;
	private double balance;
	private double monthlyInterestRate;

	public BankAccount(Customer owner, double balance, double monthlyInterestRate) {
		super();
		this.owner = owner;
		this.balance = balance;
		this.monthlyInterestRate = monthlyInterestRate;

	}

	public void depositingMoney(double amount) {
		this.balance += amount;
	}

	public String getIban() {
		return this.iban;
	}

	public String getNameOfCustomer() {
		return owner.getName();
	}

	public static String ibanToString() {
		return String.format("%08d", BankAccount.IBAN);
	}

	public double calculateInterestRate(int months) {
		return this.balance * this.monthlyInterestRate * months / 100;
	}

	public Customer getOwner() {
		return this.owner;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}
}
