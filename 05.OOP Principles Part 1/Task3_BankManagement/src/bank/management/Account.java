package bank.management;

public class Account {
	private String name;
	private String govId;
	private double balance;
	public Credentials credentials;
	
	public Account(String name) {
		this.name=name;
	}
	
	public Account(String name,String govId) {
		this.name=name;
		this.govId=govId;
	}
	
	public Account(String name,String govId,Credentials credentials) {
		this.name=name;
		this.govId=govId;
		this.credentials = credentials;
	}

	public void deposit(double amount) {
		balance +=amount;
	}
	public void withdraw(double amount) {
		balance -= amount;
	}
	public double getBalance() {
		return balance;
	}
	
	public boolean hasAccess(String password) {
		if(password.equals(credentials.getPassword())) {
			return true;
		}
		return false;
	}
	public String getUsername() {
		return credentials.getUsername();
	}
	public String getGovId() {
		return govId;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return credentials.getPassword();
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	

}
