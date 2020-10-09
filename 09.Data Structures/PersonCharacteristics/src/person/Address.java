package person;

public class Address {
	private String country;
	private String city;
	private String municipality;
	private String postalCode;
	private String street;
	private int number;
	private int floor;
	private int apartmentNo;

	public Address(String country, String city, String municipality, String postalCode, String street, int number,
			int floor, int apartmentNo) {
		this.country = country;
		this.city = city;
		this.municipality = municipality;
		this.postalCode = postalCode;
		this.street = street;
		this.number = number;
		this.floor = floor;
		this.apartmentNo = apartmentNo;
	}

	@Override
	public String toString() {
		if (floor == 0 || apartmentNo == 0) {
			return number + " " + street + " Street" + "\n" + this.postalCode + " " + municipality + "\n" + city + ", "
					+ country;
		} else {
			return number + " " + street + "\n" + "fl. " + floor + ", ap." + apartmentNo + "\n" + this.postalCode + " "
					+ municipality + "\n" + city + ", " + country;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (apartmentNo != other.apartmentNo)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (floor != other.floor)
			return false;
		if (municipality == null) {
			if (other.municipality != null)
				return false;
		} else if (!municipality.equals(other.municipality))
			return false;
		if (number != other.number)
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

}
