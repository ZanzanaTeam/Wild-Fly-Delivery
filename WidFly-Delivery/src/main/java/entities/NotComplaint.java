package entities;

import javax.persistence.Entity;

import entities.embedded.Address;

@Entity
public class NotComplaint extends Restaurant {
	
	/**
	 * 
	 */
	private String itinerary;
	
	private static final long serialVersionUID = 1L;

	public NotComplaint() {
		// TODO Auto-generated constructor stub
	}

	public NotComplaint(String id, String name, Address address, Category category,String itinerary) {
		super(id, name, address, category);
		this.itinerary = itinerary;
	}

	@Override
	public String toString() {
		return "NotComplaint [itinerary=" + itinerary + "]";
	}

	public String getItinerary() {
		return itinerary;
	}

	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}
	
	
}
