package test.basic;

import antlr.collections.List;
import entities.Menu;
import services.implementation.MenuService;

public class TestFind {

	public static void main(String[] args) {

		MenuService menuservice = new MenuService();
		
		List menu = (List) menuservice.findAll(Menu.class);
		
	}

}
