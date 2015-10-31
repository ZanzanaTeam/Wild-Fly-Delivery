package services.interfaces;

import javax.ejb.Local;

@Local
public interface RestaurantServicesLocal {
	Boolean verifCode(String code , Integer IdOwner);
}
