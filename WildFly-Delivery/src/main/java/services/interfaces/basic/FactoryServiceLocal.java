package services.interfaces.basic;

import javax.ejb.Local;

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

@Local
public interface FactoryServiceLocal {

	ServicesBasicLocal<SimpleUser> getSimpleUserEjb();

	ServicesBasicLocal<Order> getOrderEjb();

	ServicesBasicLocal<Menu> getMenusEjb();

	ServicesBasicLocal<DeliveryZone> getDeliveryZoneEjb();

	ServicesBasicLocal<ItemOrder> getItemOrderEjb();

	ServicesBasicLocal<Note> getNoteEjb();

	ServicesBasicLocal<Owner> getOwnerEjb();

	ServicesBasicLocal<MenuSpecification> getMenuSpecificationEjb();

	ServicesBasicLocal<Payment> getPayementEjb();

	ServicesBasicLocal<Category> getCategoryEjb();
	
	ServicesBasicLocal<Restaurant> getRestaurantEjb();

}
