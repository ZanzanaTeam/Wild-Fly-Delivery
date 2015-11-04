package services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modele.ModeleOrder;
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
	public List<ModeleOrder> findOrderByRestaurant(String complaint) {

		Restaurant restaurant = serviceLocal.getRestaurantEjb().findById(
				complaint, Restaurant.class);
		if (restaurant != null && restaurant instanceof Complaint) {
			String jpql = "select e from Order e where e.restaurant.id=:param";
			
			jpql = "SELECT o.id as ID , o.orderDate as CREATION_DATE, o.orderState as STATUS , c.fullName as CLIENT,sum(m.price * e.quantity) as TOTAL "
					+ "FROM ItemOrder e "
					+ "JOIN e.menu m "
					+ "JOIN e.order o "
					+ "JOIN o.customer c "
					+ "WHERE o.restaurant.id =:param "
					+ "GROUP BY e.order ";
			
			Query query = entityManager.createQuery(jpql);
			query.setParameter("param", complaint);
			
			List<Object[]> objects = query.getResultList();
			List<ModeleOrder> modeleOrders = new ArrayList();
			for (Object[] result : objects) {
			    modeleOrders.add(new ModeleOrder((String)result[0], (Date)result[1], (OrderState) result[2], (Double)result[4], (String) result[3]));
			}
			
			return modeleOrders;
		} else {
			return null;
		}
	}

	@Override
	public Double CalculTotalOrder(String orderId) {

		String jpql = "SELECT sum(m.price*o.quantity) as total FROM ItemOrder o JOIN o.menu m where o.id.orderId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", orderId);

		return (Double) query.getSingleResult();

	}

}
