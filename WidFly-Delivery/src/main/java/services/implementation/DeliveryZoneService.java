package services.implementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.DeliveryZoneServiceRemote;
import services.interfaces.basic.FactoryServiceLocal;
import entities.Complaint;
import entities.DeliveryZone;
import entities.Menu;
import entities.Restaurant;

/**
 * Session Bean implementation class DeliveryZoneService
 */
@Stateless
public class DeliveryZoneService implements DeliveryZoneServiceRemote {

	@EJB
	FactoryServiceLocal serviceLocal;
	
	@PersistenceContext
	EntityManager entityManager;

	public DeliveryZoneService() {
	}

	@Override
	public Boolean assignDeliveryZone(DeliveryZone deliveryZone, String restaurantId) {

		Restaurant complaint = serviceLocal.getRestaurantEjb().findById(
				restaurantId, Restaurant.class);
		if (complaint != null && complaint instanceof Complaint) {
			deliveryZone.setComplaint(complaint);
			serviceLocal.getDeliveryZoneEjb().update(deliveryZone);
			return true;
		}
		return false;
	}
	
	@Override
	public List<DeliveryZone> findDeliveryZoneByRestaurant(String restaurantId) {

		Restaurant complaint = serviceLocal.getRestaurantEjb().findById(
				restaurantId, Restaurant.class);
		if (complaint != null && complaint instanceof Complaint) {
			String jpql = "select e from DeliveryZone e where e.complaint.id =:param";
			Query query = entityManager.createQuery(jpql);

			query.setParameter("param", restaurantId);
			return query.getResultList();
		}

		return null;
	}

}
