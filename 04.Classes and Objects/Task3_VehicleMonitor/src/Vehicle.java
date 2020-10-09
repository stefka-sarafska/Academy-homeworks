import java.util.Scanner;

public class Vehicle {
    static int nextLicenseNo=0;
    String type;
    String model;
    int power;
    double fuelConsumption;
    int yearProduced;
    int licenseNo;
    double weight;
    String color;

    public Vehicle(String type, String model, int power, double fuelConsumption, int yearProduced,
                   double weight, String color) {
        this(type,model,power,fuelConsumption,yearProduced);
        this.weight = weight;
        this.color = color;
    }

    public Vehicle(String type, String model, int power, double fuelConsumption, int yearProduced) {
        licenseNo=nextLicenseNo;
        if(licenseNo==9999){
            nextLicenseNo=0;
        }else {
            nextLicenseNo++;
        }
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;

    }

    public void setLicenseNo(int num) {

        if (!(num >= 0 && num < 9999)) {
            return;
        } else {
            num++;
            this.licenseNo = num;

        }
    }

    public int getNumber() {
        return licenseNo;
    }

    public double calculateTripPrice(double fuelPrice, double distance) {
        return (distance / 100) * fuelPrice * this.fuelConsumption;
    }

    public double getInsurancePrice() {
        int carAge = 2020 - this.yearProduced;
        double typeCoefficient = 0;
        if (this.type.equals("car")) {
            typeCoefficient = 1;
        } else if (this.type.equals("suv")) {
            typeCoefficient = 1.12;
        } else if (this.type.equals("truck")) {
            typeCoefficient = 1.20;
        } else if (this.type.equals("motorcycle")) {
            typeCoefficient = 1.5;
        }
        double insurancePrice = (0.16 * this.power) * (1.25 * carAge) * (0.05 * this.fuelConsumption) * typeCoefficient;
        return insurancePrice;
    }

    public static void main(String[] args) {
        Scanner sp = new Scanner(System.in);
        int n = Integer.parseInt(sp.nextLine());
        double priceOfFuel = Double.parseDouble(sp.nextLine());
        double[] distances = new double[n];

        Vehicle[] vehicle = new Vehicle[n];
        for (int i = 0; i < n; i++) {

            String input = sp.nextLine();
            String[] line = input.split(", ");
            String type = line[0];
            String model = line[1];
            int power = Integer.parseInt(line[2]);
            double fuel = Double.parseDouble(line[3]);
            int year = Integer.parseInt(line[4]);
            double distance = Double.parseDouble(line[5]);
            distances[i] = distance;

            if (line.length > 6) {
                double weight = Double.parseDouble(line[6]);
                String color = line[7];

                vehicle[i] = new Vehicle(type, model, power, fuel, year, weight, color);

            } else {
                vehicle[i] = new Vehicle(type, model, power, fuel, year, 0, "N/A");
            }

        }
        for (int i = 0; i < vehicle.length; i++) {
            for (int j = i; j < distances.length; j++) {
                System.out.printf("%04d-%s,%d,%s%nInsurance cost:%.2f-Travel cost:%.2f", vehicle[i].licenseNo, vehicle[i].model, vehicle[i].yearProduced, vehicle[i].color, vehicle[i].getInsurancePrice(), vehicle[i].calculateTripPrice(priceOfFuel, distances[j]));
                System.out.println();
                break;
            }
        }

    }

}
