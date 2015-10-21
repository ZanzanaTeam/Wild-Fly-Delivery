package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface MenuServiceRemote {
	void assignMenu(int menuId , int restaurantId);
}
