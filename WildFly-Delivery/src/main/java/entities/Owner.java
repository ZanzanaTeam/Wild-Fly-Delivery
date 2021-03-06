package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import entities.embedded.Address;

@Entity
public class Owner extends Customer implements Serializable {

	private String idFoursquare;
	private String oAuthToken;
	private static final long serialVersionUID = 1L;

	private List<Restaurant> restaurants;

	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Owner(String full_name, Address address, String idFoursquare,
			String oAuthToken) {
		super(full_name, address);
		this.idFoursquare = idFoursquare;
		this.oAuthToken = oAuthToken;
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
}
