package bank.accounts;

import customers.Customer;

public class DepositAccount extends BankAccount {

	public DepositAccount(Customer owner, double balance, double monthlyInterestRate) {
		super(owner, balance, monthlyInterestRate);
		IBAN++;
		this.iban = ibanToString();
	}

	public void withDrawMoney(double amount) {
		this.setBalance(this.getBalance() - amount);
	}

}
