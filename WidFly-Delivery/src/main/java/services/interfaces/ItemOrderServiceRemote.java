package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.ItemOrder;

@Remote
public interface ItemOrderServiceRemote {

	List<ItemOrder> findItemOrderByOrder(int orderId);

	Boolean assignItemToOrder(ItemOrder item, int orderId);

	Boolean assignMenuToItemOrder(ItemOrder item, int menuId);
	
	Boolean assignItemToOrderToMenu(ItemOrder item, int orderid, int menuId);
	

}
