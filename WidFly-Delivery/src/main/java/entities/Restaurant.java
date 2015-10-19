package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import entities.embedded.Address;

@Entity
public class Restaurant implements Serializable {

	private String id;
	private String name;
	private Address address;

	private static final long serialVersionUID = 1L;

	private Category category;
	private Owner owner;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String id, String name, Address address, Category category) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address="
				+ address + ", category=" + category + "]";
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
