package test;

import delegate.MenuServiceDelegate;
import entities.Menu;

public class AddMenuToRestaurant {

	public static String RESTAURANT = "55e0db4a498e273c7595acbe";

	public static void main(String[] args) {

		MenuServiceDelegate delegate = new MenuServiceDelegate();
		delegate.assignMenu(RESTAURANT, new Menu("Pizza", 10.5,
				"Tomate , champignon , jomban"));
		
		delegate.assignMenu(RESTAURANT, new Menu("Pizza Turk", 15.5,
				"Tomate , champignon , jomban"));
		
		System.out.println(delegate.findMenuByRestaurant(RESTAURANT));
	}
}
