package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.embedded.Address;
import entities.special.ValidateOwnerRestaurant;

@Entity
public class Restaurant implements Serializable {

	private String id;
	private String name;
	private Address address;
	private String email;

	private static final long serialVersionUID = 1L;

	private Category category;
	private Owner owner;
	private List<Order> orders;
	private List<ValidateOwnerRestaurant> ownerRestaurants;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String id, String name, Address address, String email,
			Category category) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.category = category;
		this.setEmail(email);
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

	@OneToMany(mappedBy = "restaurant")
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(mappedBy = "restaurant")
	public List<ValidateOwnerRestaurant> getOwnerRestaurants() {
		return ownerRestaurants;
	}

	public void setOwnerRestaurants(
			List<ValidateOwnerRestaurant> ownerRestaurants) {
		this.ownerRestaurants = ownerRestaurants;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
