package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.DeliveryZoneServiceRemote;
import entities.DeliveryZone;
import entities.Menu;

public class DeliveryZoneServiceDelegate {
	public final String jndiName = "/WidFly-Delivery/DeliveryZoneService!services.interfaces.DeliveryZoneServiceRemote";

	private DeliveryZoneServiceRemote getProxy() {
		return (DeliveryZoneServiceRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public Boolean assignDeliveryZone(String restaurantId, DeliveryZone deliveryZone) {
		return getProxy().assignDeliveryZone(deliveryZone, restaurantId);
	}

	public List<DeliveryZone> findDeliveryZoneByRestaurant(String restaurantId) {
		return getProxy().findDeliveryZoneByRestaurant(restaurantId);
	}

}