package entities.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String street;
	private String city;
	private String country;
	private double altitude;
	private double longitude;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String country, double altitude,
			double longitude) {
		this.street = street;
		this.city = city;
		this.country = country;
		this.altitude = altitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", country="
				+ country + ", altitude=" + altitude + ", longitude="
				+ longitude + "]";
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
