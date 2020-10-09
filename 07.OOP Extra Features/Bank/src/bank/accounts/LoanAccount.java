package bank.accounts;

import customers.Customer;

public class LoanAccount extends BankAccount {

	public LoanAccount(Customer owner, double balance, double monthlyInterestRate) {
		super(owner, balance, monthlyInterestRate);
		IBAN++;
		this.iban=ibanToString();
	}

}
