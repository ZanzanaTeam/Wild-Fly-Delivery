package test;

import java.util.List;

import delegate.ItemOrderDelegateService;
import entities.ItemOrder;

public class TestFindItemOrderByOrder {

	public static int orderId = 1;
	public static String restaurantId = "55e0db4a498e273c7595acbe";

	public static void main(String[] args) {

		ItemOrderDelegateService delegate = new ItemOrderDelegateService();
		
		
		List<ItemOrder> listItem = delegate.findItemOrderByOrder(orderId);
		
		for (ItemOrder order : listItem) {
			System.out.println("Order = " + order);
		}
		
		System.out.println("It's Ok");
	}
}
