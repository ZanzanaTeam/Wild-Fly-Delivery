package services.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import services.interfaces.DeliveryZoneServiceRemote;
import services.interfaces.basic.FactoryServiceLocal;
import entities.Complaint;
import entities.DeliveryZone;

/**
 * Session Bean implementation class DeliveryZoneService
 */
@Stateless
public class DeliveryZoneService implements DeliveryZoneServiceRemote {

	@EJB
	FactoryServiceLocal factoryServiceLocal;

	public DeliveryZoneService() {
	}

	@Override
	public void assignDeliveryZone(DeliveryZone deliveryZone, int restaurantId) {

		
	}

}
