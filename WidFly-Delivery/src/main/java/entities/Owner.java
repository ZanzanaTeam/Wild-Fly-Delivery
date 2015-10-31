package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import entities.embedded.Address;
import entities.special.ValidateOwnerRestaurant;

@Entity
public class Owner extends Customer implements Serializable {

	private String idFoursquare;
	private String oAuthToken;
	private String email;
	
	private static final long serialVersionUID = 1L;

	private List<Restaurant> restaurants;
	private List<ValidateOwnerRestaurant> validateOwnerRestaurants;

	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Owner(String full_name, Address address, String email ,String idFoursquare,
			String oAuthToken) {
		super(full_name, address);
		this.idFoursquare = idFoursquare;
		this.oAuthToken = oAuthToken;
		this.email = email;
	}

	@Column(unique = true)
	public String getIdFoursquare() {
		return idFoursquare;
	}

	public void setIdFoursquare(String idFoursquare) {

		this.idFoursquare = idFoursquare;
	}

	@OneToMany(mappedBy = "owner")
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Column(unique = true)
	public String getoAuthToken() {
		return oAuthToken;
	}

	public void setoAuthToken(String oAuthToken) {
		this.oAuthToken = oAuthToken;
	}
	
	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy="owner")
	public List<ValidateOwnerRestaurant> getValidateOwnerRestaurants() {
		return validateOwnerRestaurants;
	}

	public void setValidateOwnerRestaurants(List<ValidateOwnerRestaurant> validateOwnerRestaurants) {
		this.validateOwnerRestaurants = validateOwnerRestaurants;
	}
}
