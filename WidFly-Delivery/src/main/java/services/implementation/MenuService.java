package services.implementation;

import java.util.List;

import javax.ejb.Stateless;

import services.interfaces.MenuServiceRemote;
import entities.Menu;
import entities.Order;
import entities.Restaurant;

/**
 * Session Bean implementation class MenuService
 */
@Stateless
public class MenuService implements MenuServiceRemote {

	/**
	 * Default constructor.
	 */
	public MenuService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void assignMenu(int menuId, int restaurantId) {

	}

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Menu> finMenuByRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> finMenuByOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
