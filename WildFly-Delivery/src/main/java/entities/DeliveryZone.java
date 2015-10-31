package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DeliveryZone implements Serializable {

	private Integer id;
	private String region;
	private double estimatedTime;
	private double distance;
	private double price;
	private double minPrice;

	private static final long serialVersionUID = 1L;

	private Complaint complaint; 
	
	public DeliveryZone() {
	}

	
	@Override
	public String toString() {
		return "DeliveryZone [id=" + id + ", region=" + region
				+ ", estimatedTime=" + estimatedTime + ", distance=" + distance
				+ ", price=" + price + ", minPrice=" + minPrice + "]";
	}





	public DeliveryZone(String region, double estimatedTime, double distance,
			double price, double minPrice) {
		super();
		this.region = region;
		this.estimatedTime = estimatedTime;
		this.distance = distance;
		this.price = price;
		this.minPrice = minPrice;
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
	public String getRegion() {
		return region;
	}

	public void setRegion(String name) {
		this.region = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	

	public double getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(double estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	@NotNull
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public double getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	
	@ManyToOne
	public Complaint getComplaint() {
		return complaint;
	}


	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

}
