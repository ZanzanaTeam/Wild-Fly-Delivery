package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import entities.embedded.Address;

@Entity
public class Customer implements Serializable {

	private Integer id;
	private String fullName;
	private Address address;

	private static final long serialVersionUID = 1L;

	public Customer() {

	}

	public Customer(String fullName, Address address) {
		super();
		this.fullName = fullName;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullname) {
		this.fullName = fullname;
	}

	@Override
	public String toString() {
		return "Customer [fullname=" + fullName + "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
