package test;

import delegate.ItemOrderDelegateService;
import delegate.ServicesBasicDelegate;
import entities.ItemOrder;
import entities.Menu;
import entities.Order;

public class TestAssignItemOrderToOrder {

	public static int menuId = 1;
	public static String restaurantId = "55e0db4a498e273c7595acbe";

	public static void main(String[] args) {

		ItemOrderDelegateService delegate = new ItemOrderDelegateService();

		Order order = new ServicesBasicDelegate<Order>().doCrud().findById(5,
				Order.class);

		Menu menu = new ServicesBasicDelegate<Menu>().doCrud().findById(1,Menu.class);
		ItemOrder itemorder = new ItemOrder(menu, order, 54);
		delegate.assignItemToOrderToMenu(itemorder, order.getId(), menu.getId());
		System.out.println("it's Ok");
	}
}
