package entities;

import java.io.Serializable;

import javax.persistence.Entity;

import entities.embedded.Address;

@Entity
public class Owner extends Customer implements Serializable {
	
	private String idFoursquare;
	
	private static final long serialVersionUID = 1L;
	
	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Owner(String full_name,Address address,String idFoursquare) {
		super(full_name, address);
		this.idFoursquare = idFoursquare;
	}

	public String getIdFoursquare() {
		return idFoursquare;
	}

	public void setIdFoursquare(String idFoursquare) {
		
		this.idFoursquare = idFoursquare;
	}
}
