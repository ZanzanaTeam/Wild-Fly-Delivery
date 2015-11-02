package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import entities.embedded.Address;

@Entity
public class Complaint extends Restaurant implements Serializable {

	private static final long serialVersionUID = 1L;

	public Complaint() {
		// TODO Auto-generated constructor stub
	}

	public Complaint(String id, String name, Address address, String email,
			Category category, List<Menu> menus,
			List<DeliveryZone> deliveryZones) {
		super(id, name, address, email, category);

	}

}
