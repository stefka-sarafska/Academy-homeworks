package swift.market;

public class Person {
	private String name;
	private double balance;
	public Product[] products = new Product[500];
	private int counter = 0;

	public Person(String name, double balance) {
		setName(name);
		setBalance(balance);
	}

	public void printProducts() {
		boolean firstProduct = true;
		if (products[0] != null) {
			System.out.print(this.name + "-");
			for (Product p : products) {
				if (p != null) {
					if (firstProduct) {
						System.out.print(p.getName());
						firstProduct = false;
					} else {
						System.out.print(", " + p.getName());
					}
				}
			}
			System.out.println();
		} else {
			System.out.println(this.name + "-" + "Nothing bought");
		}
	}

	public void buyProduct(Product product) {
		if (this.counter == products.length) {
			return;
		}
		if (this.balance >= product.getPrice()) {
			balance -= product.getPrice();
			products[counter] = product;
			System.out.println(name + " " + "bought" + " " + product.getName());
			counter++;
		} else {
			System.out.println(name + " " + "can't afford" + " " + product.getName());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			System.out.println("Name can't be empty.");
			System.exit(1);
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance >= 0) {
			this.balance = balance;
		} else {
			System.out.println("Balance can't be negative.");
			System.exit(1);
		}
	}

}
