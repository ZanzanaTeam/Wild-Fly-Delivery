package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Menu;
import entities.Order;
import entities.Restaurant;

@Remote
public interface MenuServiceRemote {
	void assignMenu(int menuId, int restaurantId);

	void addMenu(Menu menu);

	List<Menu> finMenuByRestaurant(Restaurant restaurant);

	List<Menu> finMenuByOrder(Order order);

}
