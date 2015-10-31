package services.implementation.basic;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import services.interfaces.basic.FactoryServiceLocal;
import services.interfaces.basic.ServicesBasicLocal;
import services.interfaces.basic.ServicesBasicRemote;
import entities.Category;
import entities.DeliveryZone;
import entities.ItemOrder;
import entities.Menu;
import entities.MenuSpecification;
import entities.Note;
import entities.Order;
import entities.Owner;
import entities.Payment;
import entities.Restaurant;
import entities.SimpleUser;

/**
 * @author MedAymen
 * 
 */

@Stateless
public class FactoryService implements FactoryServiceLocal {

	@EJB
	ServicesBasicLocal<SimpleUser> simpleUser;
	@EJB
	ServicesBasicLocal<Order> order;
	@EJB
	ServicesBasicLocal<Menu> menu;
	@EJB
	ServicesBasicLocal<DeliveryZone> deliveryZone;
	@EJB
	ServicesBasicLocal<ItemOrder> itemOrder;
	@EJB
	ServicesBasicLocal<Note> note;
	@EJB
	ServicesBasicLocal<Owner> owner;
	@EJB
	ServicesBasicLocal<MenuSpecification> menuSpecification;
	@EJB
	ServicesBasicLocal<Payment> payement;
	@EJB
	ServicesBasicLocal<Category> category;
	@EJB
	ServicesBasicLocal<Restaurant> restaurant;

	public FactoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ServicesBasicLocal<SimpleUser> getSimpleUserEjb() {
		return simpleUser;
	}

	@Override
	public ServicesBasicLocal<Order> getOrderEjb() {
		return order;
	}

	@Override
	public ServicesBasicLocal<Menu> getMenusEjb() {
		return menu;
	}

	@Override
	public ServicesBasicLocal<DeliveryZone> getDeliveryZoneEjb() {
		return deliveryZone;
	}

	@Override
	public ServicesBasicLocal<ItemOrder> getItemOrderEjb() {
		return itemOrder;
	}

	@Override
	public ServicesBasicLocal<Note> getNoteEjb() {
		return note;
	}

	@Override
	public ServicesBasicLocal<Owner> getOwnerEjb() {
		return owner;
	}

	@Override
	public ServicesBasicLocal<MenuSpecification> getMenuSpecificationEjb() {
		return menuSpecification;
	}

	@Override
	public ServicesBasicLocal<Payment> getPayementEjb() {
		return payement;
	}

	@Override
	public ServicesBasicLocal<Category> getCategoryEjb() {
		return category;
	}

	@Override
	public ServicesBasicLocal<Restaurant> getRestaurantEjb() {
		return restaurant;
	}
}
