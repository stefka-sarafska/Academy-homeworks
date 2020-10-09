package swift.market;

import java.util.Scanner;

public class MarketMain {
	private static Person[] people = new Person[200];
	private static Product[] products = new Product[500];

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String line = sp.nextLine();

		int counterPeople = 0;
		int counterProducts = 0;

		String[] inputPeople = line.split(";");
		for (String s : inputPeople) {
			String[] input = s.split("=");
			people[counterPeople] = new Person(input[0], Double.parseDouble(input[1]));
			counterPeople++;
		}

		line = sp.nextLine();
		String[] inputProducts = line.split(";");
		for (String s : inputProducts) {
			String[] input = s.split("=");
			products[counterProducts] = new Product(input[0], Double.parseDouble(input[1]));
			counterProducts++;
		}
		line = sp.nextLine();
		while (!line.equals("END")) {
			String name = line.substring(0, line.lastIndexOf(" "));
			String productName = line.substring(line.lastIndexOf(" "), line.length()).trim();
			
			Person person = findPersonByName(name);
			Product product = findProductByName(productName);
			person.buyProduct(product);

			line = sp.nextLine();
		}
		for (Person p : people) {
			if (p != null) {
				p.printProducts();
			}
		}
		sp.close();
	}

	private static Person findPersonByName(String name) {
		for (Person p : people) {
			if (p != null && p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	private static Product findProductByName(String name) {
		for (Product p : products) {
			if (p != null && p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

}
