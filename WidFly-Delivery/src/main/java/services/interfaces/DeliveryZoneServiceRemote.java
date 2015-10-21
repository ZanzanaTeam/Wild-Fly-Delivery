package services.interfaces;

import javax.ejb.Remote;

import entities.DeliveryZone;

@Remote
public interface DeliveryZoneServiceRemote {
	void assignDeliveryZone(DeliveryZone deliveryZone, int restaurantId);
}
