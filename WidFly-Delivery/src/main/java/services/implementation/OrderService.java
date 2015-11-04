package services.implementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.OrderServiceRemote;
import services.interfaces.basic.FactoryServiceLocal;
import entities.Complaint;
import entities.Order;
import entities.Restaurant;
import entities.SimpleUser;
import entities.enumeration.OrderState;

/**
 * Session Bean implementation class OrderService
 */
@Stateless
public class OrderService implements OrderServiceRemote {

	@EJB
	FactoryServiceLocal serviceLocal;

	@PersistenceContext
	EntityManager entityManager;

	public OrderService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changeState(OrderState orderState) {

	}

	@Override
	public List<Order> findOrderByCustomer(Integer simpleUser) {

		SimpleUser user = serviceLocal.getSimpleUserEjb().findById(simpleUser,
				SimpleUser.class);

		if (user != null) {
			String jpql = "select e from Order e where e.customer.id=:param";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("param", simpleUser);
			return query.getResultList();
		} else {
			return null;
		}
	}

	@Override
	public List<Order> findOrderByRestaurant(String complaint) {

		Restaurant restaurant = serviceLocal.getRestaurantEjb().findById(
				complaint, Restaurant.class);
		if (restaurant != null && restaurant instanceof Complaint) {
			String jpql = "select e from Order e where e.restaurant.id=:param";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("param", complaint);
			return query.getResultList();
		} else {
			return null;
		}
	}

}
