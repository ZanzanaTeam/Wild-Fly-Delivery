package entities;

import entities.embedded.Address;

public class Restaurant {

	private String id;
	private String name;
	private Address address;
	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
