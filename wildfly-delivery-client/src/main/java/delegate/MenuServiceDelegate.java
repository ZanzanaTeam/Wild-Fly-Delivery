package delegate;

import java.util.List;

import entities.Menu;
import locator.ServiceLocator;
import services.interfaces.MenuServiceRemote;

public class MenuServiceDelegate {
	public final String jndiName = "/WidFly-Delivery/MenuService!services.interfaces.MenuServiceRemote";

	private MenuServiceRemote getProxy() {
		return (MenuServiceRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public Boolean assignMenu(String restaurantId, Menu menu) {
		return getProxy().assignMenu(menu, restaurantId);
	}
	
	public List<Menu> findMenuByRestaurant(String restaurantId){
		return getProxy().findMenuByRestaurant(restaurantId);
	}

}