package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Restaurant;

@Remote
public interface RestaurantServicesRemote {
	
	Boolean demandeOwner(String restaurantId , Integer OwnerId);
	
	Boolean verifAndAssignRestaurant(String code, Integer IdOwner);
	
	List<Restaurant> findByName(String name);
	
	List<Restaurant> findByDistance(Double alt , Double lng,int distance);
}
