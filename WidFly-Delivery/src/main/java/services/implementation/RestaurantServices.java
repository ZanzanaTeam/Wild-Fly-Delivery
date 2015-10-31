package services.implementation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import services.interfaces.RestaurantServicesLocal;
import services.interfaces.RestaurantServicesRemote;
import services.interfaces.basic.FactoryServiceLocal;
import utility.SendMail;
import entities.Owner;
import entities.Restaurant;
import entities.special.ValidateOwnerRestaurant;

@Stateless
public class RestaurantServices implements RestaurantServicesRemote,
		RestaurantServicesLocal {

	@EJB
	FactoryServiceLocal factoryServiceLocal;

	public RestaurantServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void demandeOwner(String restaurantId, Integer OwnerId) {

		Restaurant restaurant = factoryServiceLocal.getRestaurantEjb()
				.findById(restaurantId, Restaurant.class);
		Owner owner = factoryServiceLocal.getOwnerEjb().findById(OwnerId, Owner.class);
		String code = SendMail.generateCode();
		
		factoryServiceLocal.getValidateOwnerRestaurantEjb().add(new ValidateOwnerRestaurant(code, new Date(), null, restaurant, owner));
		SendMail.sendMail(restaurant.getEmail(),code);
		
	}

	public Boolean verifCode(String code , Integer IdOwner){
		
		Owner owner = factoryServiceLocal.getOwnerEjb().findById(IdOwner, Owner.class);
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("code", code);
		where.put("Owner", owner);
		return factoryServiceLocal.getValidateOwnerRestaurantEjb().findBy(where, ValidateOwnerRestaurant.class).isEmpty();
		
	}
}
