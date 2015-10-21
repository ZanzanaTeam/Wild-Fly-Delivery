package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface DeliveryZoneServiceRemote {
	void assignDeliveryZone(int zoneId, int restaurantId);
}
