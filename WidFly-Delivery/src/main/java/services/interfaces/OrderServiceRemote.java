package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Complaint;
import entities.Order;
import entities.SimpleUser;
import entities.enumeration.OrderState;

@Remote
public interface OrderServiceRemote {

	void changeState(OrderState orderState);

	List<Order> finOrderByRestaurant(Complaint complaint);

	List<Order> finOrderByCustomer(SimpleUser simpleUser);

}
