package test;

import org.apache.commons.lang.RandomStringUtils;

import delegate.ItemOrderDelegateService;
import delegate.OrderServiceDelegate;
import delegate.ServicesBasicDelegate;
import entities.Customer;
import entities.Order;
import entities.embedded.Address;
import entities.enumeration.DeliveryType;
import entities.enumeration.OrderState;

public class TestCreateOrder {

	public static String Restaurant = "4b52d9a0f964a5203f8927e3";
	public static Integer SimpleUser = 1;

	public static void main(String[] args) {

		ServicesBasicDelegate<Order> basicDelegate = new ServicesBasicDelegate<Order>();
		String id = RandomStringUtils.random(5, false, true);
		Order order = new Order(id, new Address("1", "Tunis", "Tunisie", 0, 0),
				OrderState.Pending, DeliveryType.Normal);

		order.setCustomer(new ServicesBasicDelegate<Customer>().doCrud()
				.findById(SimpleUser, Customer.class));
		order.setRestaurant(new ServicesBasicDelegate<entities.Restaurant>()
				.doCrud().findById(Restaurant, entities.Restaurant.class));

		basicDelegate.doCrud().add(order);

		OrderServiceDelegate orderServiceDelegate = new OrderServiceDelegate();

		System.out.println("Find By Customer : \n \t ");
		System.out
				.println(orderServiceDelegate.findOrderByCustomer(SimpleUser));

		System.out.println("Find By Restaurant : \n \t ");
		System.out.println(orderServiceDelegate
				.findOrderByRestaurant(Restaurant));

		ItemOrderDelegateService itemOrderDelegateService = new ItemOrderDelegateService();

		itemOrderDelegateService.assignItemToOrderToMenu(2.0, id, 18);
		itemOrderDelegateService.assignItemToOrderToMenu(1.0, id, 19);

		System.out.println("Order num " + id + " : \n \t ");
		System.out.println(itemOrderDelegateService.findItemOrderByOrder(id));

		System.out.println("Total : "
				+ orderServiceDelegate.CalculTotalOrder(id));
	}
}
