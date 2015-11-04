package test;

import delegate.DeliveryZoneServiceDelegate;
import delegate.MenuServiceDelegate;
import entities.DeliveryZone;
import entities.Menu;

public class AddDeliveryZoneToRestaurant {

	public static String RESTAURANT = "4ba60183f964a520f62d39e3";

	public static void main(String[] args) {

		DeliveryZoneServiceDelegate delegate = new DeliveryZoneServiceDelegate();
		
		delegate.assignDeliveryZone(RESTAURANT, new DeliveryZone("Tunis", 1, 10, 3, 10));
		delegate.assignDeliveryZone(RESTAURANT, new DeliveryZone("banlieu nord tunis", 2, 10, 5, 20));
		delegate.assignDeliveryZone(RESTAURANT, new DeliveryZone("banlieu nord sud", 2, 10, 5, 20));
		
		System.out.println(delegate.findDeliveryZoneByRestaurant(RESTAURANT));
	}
}
