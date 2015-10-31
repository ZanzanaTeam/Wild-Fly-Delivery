package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface RestaurantServicesRemote {
	
	void demandeOwner(String restaurantId , Integer OwnerId);
	
	Boolean verifCode(String code, Integer IdOwner);
}
