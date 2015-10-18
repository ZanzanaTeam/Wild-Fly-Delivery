package entities;

import java.util.List;

public class Complaint extends Restaurant {

	private List<Menu> menus;
	private List<DeliveryZone> deliveryZones;

	public Complaint() {
		// TODO Auto-generated constructor stub
	}

	public Complaint(List<Menu> menus, List<DeliveryZone> deliveryZones) {
		this.menus = menus;
		this.deliveryZones = deliveryZones;
	}

	@Override
	public String toString() {
		return "Complaint \n [menus=" + menus + ", \n deliveryZones=" + deliveryZones
				+ "]";
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<DeliveryZone> getDeliveryZones() {
		return deliveryZones;
	}

	public void setDeliveryZones(List<DeliveryZone> deliveryZones) {
		this.deliveryZones = deliveryZones;
	}
	
	
	
}
