package services.implementation;

import javax.ejb.Stateless;

import services.interfaces.DeliveryZoneServiceRemote;

/**
 * Session Bean implementation class DeliveryZoneService
 */
@Stateless
public class DeliveryZoneService implements DeliveryZoneServiceRemote {

	/**
	 * Default constructor.
	 */
	public DeliveryZoneService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void assignDeliveryZone(int zoneId, int restaurantId) {
		// TODO Auto-generated method stub

	}

}
