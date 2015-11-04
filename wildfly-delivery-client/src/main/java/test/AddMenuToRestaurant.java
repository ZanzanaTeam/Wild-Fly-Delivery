package test;

import delegate.MenuServiceDelegate;
import entities.Menu;

public class AddMenuToRestaurant {

	public static String RESTAURANT = "4ba60183f964a520f62d39e3";

	public static void main(String[] args) {

		MenuServiceDelegate delegate = new MenuServiceDelegate();
		delegate.assignMenu(RESTAURANT, new Menu("Pizza", 10.5,
				"Tomate , champignon , jomban"));
		
		delegate.assignMenu(RESTAURANT, new Menu("Pizza Turk", 15.5,
				"Tomate , champignon , jomban"));
		
		System.out.println(delegate.findMenuByRestaurant(RESTAURANT));
	}
}
