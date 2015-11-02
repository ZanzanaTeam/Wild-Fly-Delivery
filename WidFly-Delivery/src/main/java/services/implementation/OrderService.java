package services.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import services.interfaces.OrderServiceRemote;
import services.interfaces.basic.FactoryServiceLocal;
import entities.Complaint;
import entities.Menu;
import entities.Order;
import entities.SimpleUser;
import entities.enumeration.OrderState;

/**
 * Session Bean implementation class OrderService
 */
@Stateless
public class OrderService implements OrderServiceRemote {

	@EJB
	FactoryServiceLocal serviceLocal;

	private EntityManager entityManager;
	
	public OrderService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changeState(OrderState orderState) {

	}

	@Override
	public List<Order> findOrderByCustomer(SimpleUser simpleUser) {
		Map<String, Object> where = new HashMap();
		where.put("customer", simpleUser);
		List<Order> list = serviceLocal.getOrderEjb().findBy(where, Order.class);

		return list;

	}

	@Override
	public List<Order> findOrderByRestaurant(Complaint complaint) {
		Map<String, Object> where = new HashMap();
		where.put("restaurant", complaint);
		List<Order> list = serviceLocal.getOrderEjb().findBy(where, Order.class);

		return list;


	}

}
