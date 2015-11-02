package entities;

import java.io.Serializable;

import javax.persistence.Entity;

import entities.embedded.Address;
import entities.enumeration.Gender;

@Entity
public class SimpleUser extends Customer implements Serializable {

	private String phoneNumber;
	private Gender gender;
	private static final long serialVersionUID = 1L;

	public SimpleUser() {

	}

	public SimpleUser(String full_name, Address address, String phoneNumber,
			Gender gender) {
		super(full_name, address);
		this.phoneNumber = phoneNumber;

		this.gender = gender;
	}

	@Override
	public String toString() {
		return "SimpleUser [name = " + getFullName() + "address="
				+ getAddress() + ", phone_number=" + phoneNumber + "gender="
				+ gender + "]";
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
