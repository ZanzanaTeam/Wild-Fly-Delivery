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
	ServicesBasicRemote<Order> order;
	@EJB
	ServicesBasicRemote<Menu> menu;
	@EJB
	ServicesBasicRemote<DeliveryZone> deliveryZone;
	@EJB
	ServicesBasicRemote<ItemOrder> itemOrder;
	@EJB
	ServicesBasicRemote<Note> note;
	@EJB
	ServicesBasicRemote<Owner> owner;
	@EJB
	ServicesBasicRemote<MenuSpecification> menuSpecification;
	@EJB
	ServicesBasicRemote<Payment> payement;
	@EJB
	ServicesBasicLocal<Category> category;

	public FactoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ServicesBasicLocal<SimpleUser> getSimpleUserEjb() {
		return simpleUser;
	}

	@Override
	public ServicesBasicRemote<Order> getOrderEjb() {
		return order;
	}

	@Override
	public ServicesBasicRemote<Menu> getMenusEjb() {
		return menu;
	}

	@Override
	public ServicesBasicRemote<DeliveryZone> getDeliveryZoneEjb() {
		return deliveryZone;
	}

	@Override
	public ServicesBasicRemote<ItemOrder> getItemOrderEjb() {
		return itemOrder;
	}

	@Override
	public ServicesBasicRemote<Note> getNoteEjb() {
		return note;
	}

	@Override
	public ServicesBasicRemote<Owner> getOwnerEjb() {
		return owner;
	}

	@Override
	public ServicesBasicRemote<MenuSpecification> getMenuSpecificationEjb() {
		return menuSpecification;
	}

	@Override
	public ServicesBasicRemote<Payment> getPayementEjb() {
		return payement;
	}

	@Override
	public ServicesBasicLocal<Category> getCategoryEjb() {
		return category;
	}
}
