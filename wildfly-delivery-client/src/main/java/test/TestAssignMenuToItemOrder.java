package test;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import services.implementation.OrderService;
import services.implementation.basic.ServicesBasic;
import services.interfaces.basic.FactoryServiceLocal;
import delegate.ItemOrderDelegateService;
import delegate.MenuServiceDelegate;
import delegate.ServicesBasicDelegate;
import entities.ItemOrder;
import entities.Menu;
import entities.Order;
import entities.SimpleUser;
import entities.embedded.Address;


public class TestAssignMenuToItemOrder {

	public static int menuId = 1;
	public static String restaurantId = "55e0db4a498e273c7595acbe";

	public static void main(String[] args) {

		ItemOrderDelegateService delegate = new ItemOrderDelegateService();
		MenuServiceDelegate menudelegate = new MenuServiceDelegate();
		ItemOrder itemOrder = new ItemOrder(new Menu(), new Order(), 1);
		List<Menu> lMenu = menudelegate.findMenuByRestaurant(restaurantId);
		Menu menu = lMenu.get(1);
//		Order order = new Order(null, new Address(), null,null);
//		
//		itemOrder.setMenu(menu);
//		
//		new ServicesBasicDelegate<ItemOrder>().doCrud().add(itemOrder);
//		
//		delegate.assignMenuToItemOrder(itemOrder, menu.getId());
		
		System.out.println("C Bon");
	}
}
