package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.OrderServiceRemote;
import entities.Order;

public class OrderServiceDelegate {
	public final String jndiName = "/WidFly-Delivery/OrderService!services.interfaces.OrderServiceRemote";

	private OrderServiceRemote getProxy() {
		return (OrderServiceRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public List<Order> findOrderByCustomer(Integer customer_id) {
		return getProxy().findOrderByCustomer(customer_id);
	}

	public List<Order> findOrderByRestaurant(String restaurant) {
		return getProxy().findOrderByRestaurant(restaurant);
	}
}