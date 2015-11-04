package test.basic;


import services.implementation.MenuService;
import services.implementation.basic.ServicesBasic;
import delegate.ServicesBasicDelegate;
import entities.Menu;

public class TestFind {

	public static void main(String[] args) {

		MenuService menuservice = new MenuService();
		ServicesBasic<Menu> servicesBasic = new ServicesBasic<Menu>();
		Menu menu = new Menu();
		menu.setDetails("Test Détails");
		menu.setName("Test Menu");
		menu.setPrice(10.3);
		menuservice.update(menu);
		servicesBasic.add(menu);
		new ServicesBasicDelegate<Menu>().doCrud().add(menu);
//	    List list = menuservice.findAll(Menu.class);
//	    
//	    for (Menu item : list) {
//			System.out.println("Menu =" + item);
//		}
	}

}
