package test;

import org.apache.commons.lang.RandomStringUtils;

import delegate.RestaurantServiceDelegate;
import delegate.ServicesBasicDelegate;
import entities.Order;

public class TestCreateOrder {

	public static Double ALT = 36.820678;
	public static Double LNG = 10.144877;
	public static Integer RADIUS = 10;

	public static void main(String[] args) {
		ServicesBasicDelegate<Order> basicDelegate = new ServicesBasicDelegate<Order>();
		String id = RandomStringUtils.random(5, false, true);
		//basicDelegate.doCrud().add(new Order(id, orderDate, locationDelivery, orderState, livraisonType))
	
	}
}
