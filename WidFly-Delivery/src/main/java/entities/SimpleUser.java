package entities;

import java.io.Serializable;

import javax.persistence.Entity;

import entities.embedded.Address;
import entities.enumeration.Gender;

@Entity
public class SimpleUser extends Customer implements Serializable {

	private String phoneNumber;
	private String email;
	private Gender gender;
	private static final long serialVersionUID = 1L;

	
	public SimpleUser() {

	}


	public SimpleUser(String full_name,Address address, String phoneNumber, String email,
			Gender gender) {
		super(full_name,address);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "SimpleUser [name = "+getFullName()+"address=" + getAddress() + ", phone_number="
				+ phoneNumber + ", email=" + email + ", gender=" + gender
				+ "]";
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}	
}
