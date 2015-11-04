package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.ItemOrder;

@Remote
public interface ItemOrderServiceRemote {

	List<ItemOrder> findItemOrderByOrder(String orderId);

	Boolean assignItemToOrderToMenu(Double quantity, String orderid, int menuId);
	
}
