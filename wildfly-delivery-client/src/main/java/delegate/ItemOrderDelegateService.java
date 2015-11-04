package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.ItemOrderServiceRemote;
import entities.ItemOrder;

public class ItemOrderDelegateService {
	public final String jndiName = "/WidFly-Delivery/ItemOrderService!services.interfaces.ItemOrderServiceRemote";

	private ItemOrderServiceRemote getProxy() {
		return (ItemOrderServiceRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public List<ItemOrder> findItemOrderByOrder(int orderId) {
		return getProxy().findItemOrderByOrder(orderId);
	}

	public Boolean assignItemToOrder(ItemOrder item, int orderId) {
		return getProxy().assignItemToOrder(item, orderId);
	}

	public Boolean assignMenuToItemOrder(ItemOrder item, int menuId) {
		return getProxy().assignMenuToItemOrder(item, menuId);
	}


	public Boolean assignItemToOrderToMenu(ItemOrder item, int orderId, int menuId) {
		return getProxy().assignItemToOrderToMenu(item, orderId, menuId);
	}

}
