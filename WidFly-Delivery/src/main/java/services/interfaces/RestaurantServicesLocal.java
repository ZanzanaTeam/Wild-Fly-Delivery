package services.interfaces;

import javax.ejb.Local;

@Local
public interface RestaurantServicesLocal {
	Boolean verifAndAssignRestaurant(String code , Integer IdOwner);
}
