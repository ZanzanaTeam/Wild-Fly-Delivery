package delegate;

import locator.ServiceLocator;
import services.interfaces.RestaurantServicesRemote;
import services.interfaces.basic.ServicesBasicRemote;

public class DemandeOwnerServiceDelegate {
	public final String jndiName = "/WidFly-Delivery/RestaurantServices!services.interfaces.RestaurantServicesRemote";

	private RestaurantServicesRemote getProxy() {
		return (RestaurantServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public void demandeOwner(String restaurantId, Integer OwnerId) {
		getProxy().demandeOwner(restaurantId, OwnerId);
	}
}