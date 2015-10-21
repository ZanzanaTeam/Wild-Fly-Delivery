package services.implementation;

import java.util.List;

import javax.ejb.Stateless;

import services.interfaces.OrderServiceRemote;
import entities.Complaint;
import entities.Order;
import entities.SimpleUser;
import entities.enumeration.OrderState;

/**
 * Session Bean implementation class OrderService
 */
@Stateless
public class OrderService implements OrderServiceRemote {

	public OrderService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changeState(OrderState orderState) {

	}

	@Override
	public List<Order> finOrderByCustomer(SimpleUser simpleUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> finOrderByRestaurant(Complaint complaint) {
		// TODO Auto-generated method stub
		return null;
	}

}
