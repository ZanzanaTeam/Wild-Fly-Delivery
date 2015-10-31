package services.interfaces;

import javax.ejb.Remote;

import entities.special.ValidateOwnerRestaurant;

@Remote
public interface RestaurantServicesRemote {
	
	void demandeOwner(String restaurantId , Integer OwnerId);
}
