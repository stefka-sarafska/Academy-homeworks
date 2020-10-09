package com.swiftacad.JsonMaven;

import java.io.Serializable;

public class Address implements Serializable {
	private String streetAddress;
	private String city;
	private String state;
	private int postalCode;

	public Address() {
		super();
	}

	public Address(String streetAddress, String city, String state, int postalCode) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + "]";
	}

}
