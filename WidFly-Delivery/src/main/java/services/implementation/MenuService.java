package services.implementation;

import javax.ejb.Stateless;

import services.interfaces.MenuServiceRemote;

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
		// TODO Auto-generated method stub

	}

}
