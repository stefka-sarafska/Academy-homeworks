package bank.accounts;

import customers.Customer;

public class MortgageAccount extends BankAccount{

	public MortgageAccount(Customer owner, double balance, double monthlyInterestRate) {
		super(owner, balance, monthlyInterestRate);
		IBAN++;
		this.iban=ibanToString();
	}

}
