package services.interfaces.basic;

import javax.ejb.Local;

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

@Local
public interface FactoryServiceLocal {
	ServicesBasicRemote<SimpleUser> getSimpleUserEjb();

	ServicesBasicRemote<Order> getOrderEjb();

	ServicesBasicRemote<Menu> getMenusEjb();

	ServicesBasicRemote<DeliveryZone> getDeliveryZoneEjb();

	ServicesBasicRemote<ItemOrder> getItemOrderEjb();

	ServicesBasicRemote<Note> getNoteEjb();

	ServicesBasicRemote<Owner> getOwnerEjb();

	ServicesBasicRemote<MenuSpecification> getMenuSpecificationEjb();

	ServicesBasicRemote<Payment> getPayementEjb();
}
