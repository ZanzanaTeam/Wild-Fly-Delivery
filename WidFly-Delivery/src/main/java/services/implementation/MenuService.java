package services.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import services.implementation.basic.ServicesBasic;
import services.interfaces.MenuServiceRemote;
import services.interfaces.basic.FactoryServiceLocal;
import entities.Menu;
import entities.Order;
import entities.Restaurant;

/**
 * Session Bean implementation class MenuService
 */
@Stateless
public class MenuService extends ServicesBasic implements MenuServiceRemote {

	@EJB
	FactoryServiceLocal serviceLocal;

	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public MenuService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean assignMenu(int menuId, int restaurantId) {
		Menu menu = serviceLocal.getMenusEjb().findById(menuId, Menu.class);

		Restaurant complaint = serviceLocal.getRestaurantEjb().findById(
				restaurantId, Restaurant.class);
		if (menu != null && complaint != null) {
			menu.setComplaint(complaint);
			serviceLocal.getMenusEjb().update(menu);
			return true;
		}
		return false;
	}

	@Override
	public List<Menu> finMenuByRestaurant(Restaurant restaurant) {
		Map<String, Object> where = new HashMap();
		where.put("restaurant ", restaurant);
		List<Menu> list = serviceLocal.getMenusEjb().findBy(where, Menu.class);

		return list;
	}

	@Override
	public List<Menu> finMenuByOrder(Order order) {

		Map<String, Object> where = new HashMap();
		where.put("order ", order);
		List<Menu> list = serviceLocal.getMenusEjb().findBy(where, Menu.class);

		return list;
	}
}
