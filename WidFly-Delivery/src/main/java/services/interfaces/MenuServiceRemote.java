package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Menu;
import entities.Order;
import entities.Restaurant;

@Remote
public interface MenuServiceRemote {
	Boolean assignMenu(Menu menu, String restaurantId);

	List<Menu> findMenuByRestaurant(String restaurantId);

	List<Menu> findMenuByOrder(Order order);

}
