package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import entities.embedded.Address;

@Entity
public class Complaint extends Restaurant  {

	/**
	 * 
	 */
	
	private List<Menu> menus;
	private List<DeliveryZone> deliveryZones;

	private static final long serialVersionUID = 1L;

	public Complaint() {
		// TODO Auto-generated constructor stub
	}

	public Complaint(String id, String name, Address address, String email ,Category category,List<Menu> menus, List<DeliveryZone> deliveryZones) {
		super(id, name, address,email, category);
		this.menus = menus;
		this.deliveryZones = deliveryZones;
	}

	@Override
	public String toString() {
		return "Complaint \n [menus=" + menus + ", \n deliveryZones=" + deliveryZones
				+ "]";
	}

	@OneToMany(mappedBy="complaint")
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@OneToMany(mappedBy="complaint")
	public List<DeliveryZone> getDeliveryZones() {
		return deliveryZones;
	}

	public void setDeliveryZones(List<DeliveryZone> deliveryZones) {
		this.deliveryZones = deliveryZones;
	}
	
	
	
}
