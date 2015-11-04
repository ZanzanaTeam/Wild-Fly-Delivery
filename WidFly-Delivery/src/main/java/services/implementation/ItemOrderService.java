package services.implementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.implementation.basic.ServicesBasic;
import services.interfaces.ItemOrderServiceRemote;
import services.interfaces.basic.FactoryServiceLocal;
import entities.ItemOrder;
import entities.Menu;
import entities.Order;

/**
 * Session Bean implementation class ItemOrderService
 */

@Stateless
public class ItemOrderService extends ServicesBasic implements
		ItemOrderServiceRemote {

	@EJB
	FactoryServiceLocal serviceLocal;

	@PersistenceContext
	EntityManager entityManager;

	public ItemOrderService() {

	}

	@Override
	public List<ItemOrder> findItemOrderByOrder(int orderId) {

		Order order = serviceLocal.getOrderEjb().findById(orderId, Order.class);
		if (order != null && order instanceof Order) {
			String jpql = "select e from ItemOrder e where e.order.id =:param";
			Query query = entityManager.createQuery(jpql);

			query.setParameter("param", orderId);
			return query.getResultList();
		}

		return null;
	}

	@Override
	public Boolean assignItemToOrder(ItemOrder item, int orderId) {

		Order order = serviceLocal.getOrderEjb().findById(orderId, Order.class);
		if (order != null) {
			item.setOrder(order);
			serviceLocal.getItemOrderEjb().update(item);
			return true;
		}
		return false;
	}

	@Override
	public Boolean assignMenuToItemOrder(ItemOrder item, int menuId) {

		Menu menu = serviceLocal.getMenusEjb().findById(menuId, Menu.class);
		if (menu != null && menu instanceof Menu) {
			item.setMenu(menu);
			serviceLocal.getItemOrderEjb().update(item);
			return true;
		}
		return false;
	}

	@Override
	public Boolean assignItemToOrderToMenu(ItemOrder item, int orderid,
			int menuId){
			
			Order order = serviceLocal.getOrderEjb().findById(orderid, Order.class);

			Menu menu = serviceLocal.getMenusEjb().findById(menuId, Menu.class);
	if (order != null && menu != null) {
		item.setOrder(order);
		item.setMenu(menu);  
		serviceLocal.getItemOrderEjb().update(item);
		return true;
	}
	return false;
	}

}
