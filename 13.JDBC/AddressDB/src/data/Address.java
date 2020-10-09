package data;

public class Address {
	private int street_id;
	private int number;
	private String street;
	private int apartmentNo;
	private String municipality;
	private String populatedArea;
	private String region;
	private String country;

	public Address(int street_id, int number, int apartmenNo) {
		this.street_id = street_id;
		this.number = number;
		this.apartmentNo = apartmenNo;
	}
	
	

	public Address(int number, String street, int apartmentNo) {
		super();
		this.number = number;
		this.street = street;
		this.apartmentNo = apartmentNo;
	}



	public Address(int number, String street, int apartmenNo, String municipality, String populatedArea, String region,
			String country) {
		super();
		this.number = number;
		this.street = street;
		this.apartmentNo = apartmenNo;
		this.municipality = municipality;
		this.populatedArea = populatedArea;
		this.region = region;
		this.country = country;
	}


	public int getStreet_id() {
		return street_id;
	}

	public int getNumber() {
		return number;
	}

	public int getApartmenNo() {
		return apartmentNo;
	}


	@Override
	public String toString() {
		return String.valueOf(number) + " " + street + " Street, Ap." + apartmentNo + "\n" + municipality + ", "
				+ populatedArea + "\n" + region + ", " + country;
	}
	
	public String printStreet() {
		return String.valueOf(number) + " " + street + " Street, Ap." + apartmentNo;
	}
	

}
