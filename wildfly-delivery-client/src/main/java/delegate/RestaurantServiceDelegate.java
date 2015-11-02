package delegate;

import java.util.List;

import entities.Restaurant;
import locator.ServiceLocator;
import services.interfaces.RestaurantServicesRemote;

public class RestaurantServiceDelegate {
	public final String jndiName = "/WidFly-Delivery/RestaurantServices!services.interfaces.RestaurantServicesRemote";

	private RestaurantServicesRemote getProxy() {
		return (RestaurantServicesRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public Boolean demandeOwner(String restaurantId, Integer OwnerId) {
		return getProxy().demandeOwner(restaurantId, OwnerId);
	}

	public Boolean AssignRestaurant(String code, int ownerId) {
		return getProxy().verifAndAssignRestaurant(code, ownerId);
	}
	
	public List<Restaurant> findByName(String name){
		return getProxy().findByName(name);
	}
	
	public List<Restaurant> findByDistance(Double alt , Double lng , int distance){
		return getProxy().findByDistance(alt, lng, distance);
	}
}