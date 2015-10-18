package entities;

public class NotComplaint extends Restaurant {
	
	private String itinerary;
	
	public NotComplaint() {
		// TODO Auto-generated constructor stub
	}

	public NotComplaint(String itinerary) {
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
