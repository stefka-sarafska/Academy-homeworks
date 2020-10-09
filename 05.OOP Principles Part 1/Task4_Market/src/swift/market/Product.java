package swift.market;

public class Product {
	private String name;
	private double price;

	public Product(String name, double price) {
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name != " ") {
			this.name = name;
		} else {
			System.out.println("Name can't be empty.");
			System.exit(1);
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
		} else {
			System.out.println("Balance can't be negative.");
			System.exit(1);
		}
	}

}
