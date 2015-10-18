package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class DeliveryZone implements Serializable {

	private Integer id;
	private String name;
	private double time;
	private double distance;
	private double price;

	private static final long serialVersionUID = 1L;

	public DeliveryZone() {
	}

	public DeliveryZone(String name, double time, double distance, double price) {
		this.name = name;
		this.time = time;
		this.distance = distance;
		this.setPrice(price);
	}


	@Override
	public String toString() {
		return "DeliveryZone [id=" + id + ", name=" + name + ", time=" + time
				+ ", distance=" + distance + ", price=" + price + "]";
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@NotNull
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
