package services.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.implementation.basic.ServicesBasic;
import services.interfaces.MenuServiceRemote;
import services.interfaces.basic.FactoryServiceLocal;
import entities.Complaint;
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

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public MenuService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean assignMenu(Menu menu, String restaurantId) {

		Restaurant complaint = serviceLocal.getRestaurantEjb().findById(
				restaurantId, Restaurant.class);
		if (complaint != null && complaint instanceof Complaint) {
			menu.setComplaint(complaint);
			serviceLocal.getMenusEjb().update(menu);
			return true;
		}
		return false;
	}

	@Override
	public List<Menu> findMenuByRestaurant(String restaurantId) {

		Restaurant complaint = serviceLocal.getRestaurantEjb().findById(
				restaurantId, Restaurant.class);
		if (complaint != null && complaint instanceof Complaint) {
			String jpql = "select e from Menu e where e.complaint.id =:param";
			Query query = entityManager.createQuery(jpql);

			query.setParameter("param", restaurantId);
			return query.getResultList();
		}

		return null;
	}

	@Override
	public List<Menu> findMenuByOrder(Order order) {

		Map<String, Object> where = new HashMap();
		where.put("order ", order);
		List<Menu> list = serviceLocal.getMenusEjb().findBy(where, Menu.class);

		return list;
	}
}
