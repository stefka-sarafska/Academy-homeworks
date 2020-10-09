package com.swiftacad.JsonMaven;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
	private String name;
	private int age;
	private Address addresss;
	private List<PhoneNumber> phoneNumbers;

	public Person() {
		super();
	}

	public Person(String name, int age, Address addresss, List<PhoneNumber> phoneNumbers) {
		super();
		this.name = name;
		this.age = age;
		this.addresss = addresss;
		this.phoneNumbers = phoneNumbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddresss() {
		return addresss;
	}

	public void setAddresss(Address addresss) {
		this.addresss = addresss;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addresss=" + addresss + ", phoneNumbers=" + phoneNumbers
				+ "]";
	}

}
