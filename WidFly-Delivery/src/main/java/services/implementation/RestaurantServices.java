package services.implementation;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.RestaurantServicesLocal;
import services.interfaces.RestaurantServicesRemote;
import services.interfaces.basic.FactoryServiceLocal;
import utility.SendMail;
import entities.Complaint;
import entities.Owner;
import entities.Restaurant;
import entities.special.ValidateOwnerRestaurant;

@Stateless
public class RestaurantServices implements RestaurantServicesRemote,
		RestaurantServicesLocal {

	@EJB
	FactoryServiceLocal factoryServiceLocal;

	@PersistenceContext
	EntityManager entityManager;

	public RestaurantServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void demandeOwner(String restaurantId, Integer OwnerId) {

		Restaurant restaurant = factoryServiceLocal.getRestaurantEjb()
				.findById(restaurantId, Restaurant.class);
		Owner owner = factoryServiceLocal.getOwnerEjb().findById(OwnerId,
				Owner.class);
		String code = SendMail.generateCode();

		factoryServiceLocal.getValidateOwnerRestaurantEjb().add(
				new ValidateOwnerRestaurant(code, new Date(), null, restaurant,
						owner));
		SendMail.sendMail(restaurant.getEmail(), code);

	}

	public Boolean verifAndAssignRestaurant(String code, Integer IdOwner) {

		Owner owner = factoryServiceLocal.getOwnerEjb().findById(IdOwner,
				Owner.class);
		String jpql = "select e from ValidateOwnerRestaurant e where e.code =:code and e.owner.id=:owner";
		Query sql = entityManager.createQuery(jpql);
		sql.setParameter("code", code);
		sql.setParameter("owner", IdOwner);

		ValidateOwnerRestaurant ownerRestaurant = (ValidateOwnerRestaurant) sql.getSingleResult();
		if (ownerRestaurant == null)
			return false;
		else
		{
			System.out.println(ownerRestaurant);
			Restaurant restaurant = factoryServiceLocal.getRestaurantEjb().findById(ownerRestaurant.getRestaurant().getId(), Restaurant.class);
			
			factoryServiceLocal.getValidateOwnerRestaurantEjb().delete(ownerRestaurant);
			factoryServiceLocal.getRestaurantEjb().delete(restaurant);
			
			restaurant = new Complaint(restaurant.getId(),
					restaurant.getName(), restaurant.getAddress(),
					restaurant.getEmail(), restaurant.getCategory(), null, null);
			restaurant.setOwner(owner);
			
			factoryServiceLocal.getRestaurantEjb().add(restaurant);
			
			ownerRestaurant.getRestaurant().setOwner(owner);
			
			return true;
		}

	}

}
