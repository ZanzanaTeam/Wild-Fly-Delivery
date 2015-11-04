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

	public List<ItemOrder> findItemOrderByOrder(String orderId) {
		return getProxy().findItemOrderByOrder(orderId);
	}

	public Boolean assignItemToOrderToMenu(Double quantity, String orderId,
			int menuId) {
		return getProxy().assignItemToOrderToMenu(quantity, orderId, menuId);
	}

}
