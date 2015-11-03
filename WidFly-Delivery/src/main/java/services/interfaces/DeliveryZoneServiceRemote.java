package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.DeliveryZone;

@Remote
public interface DeliveryZoneServiceRemote {
	Boolean assignDeliveryZone(DeliveryZone deliveryZone, String restaurantId);
	List<DeliveryZone> findDeliveryZoneByRestaurant(String RestaurantId);
}
