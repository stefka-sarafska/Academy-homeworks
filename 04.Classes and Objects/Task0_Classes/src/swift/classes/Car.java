package swift.classes;

public class Car {
	String brand;
	String model;
	int enginePower;
	int yearOfCar;

	public Car(String brand, String model, int yearOfCar, int enginePower) {
		this.brand = brand;
		this.model = model;
		this.enginePower = enginePower;
		this.yearOfCar = yearOfCar;
	}

	public String insuranceCategory(int year) {
		int yearsOfCar = 2020 - year;
		String category = " ";
		if (yearsOfCar < 8) {
			category = "Category One";

		} else if (yearsOfCar >= 8 && yearsOfCar < 15) {
			category = "Category Two";

		} else if (yearsOfCar >= 15 && yearsOfCar <= 25) {
			category = "Category Three";

		} else if (yearsOfCar > 25) {
			category = "Category Four";

		}
		return category;
	}

	public double insurance(Car searchedCar) {
		double insurance = 0;
		if (searchedCar.insuranceCategory(searchedCar.getYearOfCar()).equals("Category One")) {
			insurance = 150;
			if (searchedCar.enginePower < 80) {
				insurance += insurance * 0.2;
			} else if (searchedCar.enginePower > 140) {
				insurance += insurance * 0.45;
			}
		} else if (searchedCar.insuranceCategory(searchedCar.getYearOfCar()).equals("Category Two")) {
			insurance = 200;
			if (searchedCar.enginePower < 80) {
				insurance += insurance * 0.2;
			} else if (searchedCar.enginePower > 140) {
				insurance += insurance * 0.45;
			}
		} else if (searchedCar.insuranceCategory(searchedCar.getYearOfCar()).equals("Category Three")) {
			insurance = 300;
			if (searchedCar.enginePower < 80) {
				insurance += insurance * 0.2;
			} else if (searchedCar.enginePower > 140) {
				insurance += insurance * 0.45;
			}
		} else if (searchedCar.insuranceCategory(searchedCar.getYearOfCar()).equals("Category Four")) {
			insurance = 500;
			if (searchedCar.enginePower < 80) {
				insurance += insurance * 0.2;
			} else if (searchedCar.enginePower > 140) {
				insurance += insurance * 0.45;
			}
		}
		return insurance;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	public int getYearOfCar() {
		return yearOfCar;
	}

	public void setYearOfCar(int yearOfCar) {
		this.yearOfCar = yearOfCar;
	}

	public static void main(String[] args) {
		Car car = new Car("Mercedes-Benz", "S220", 2009, 160);
//        Car carOne = new Car("Opel", "Astra", 1996 ,85);
//        Car carTwo = new Car("Bugatti", "Veyron", 2015 ,612);
//        Car carThree = new Car("Lada", "5", 1989 ,75);
//        System.out.println(car.insuranceCategory(car.getYearOfCar()));
		System.out.println(car.insurance(car));
//        System.out.println(carOne.insurance(carOne));
//        System.out.println(carTwo.insurance(carTwo));
//        System.out.println(carThree.insurance(carThree));

	}
}
