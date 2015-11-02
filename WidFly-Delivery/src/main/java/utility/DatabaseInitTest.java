package utility;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.interfaces.FoursquareServiceLocal;
import services.interfaces.RestaurantServicesLocal;
import services.interfaces.basic.FactoryServiceLocal;
import entities.Category;
import entities.Restaurant;

@Singleton
@LocalBean
@Startup
public class DatabaseInitTest {

	@EJB
	FactoryServiceLocal serviceLocal;
	@EJB
	FoursquareServiceLocal foursquareLocal;

	@EJB
	RestaurantServicesLocal restaurant;

	@PostConstruct
	public void initDb() {
		/*
		 * System.out.println("Begin init");
		 * serviceLocal.getSimpleUserEjb().add( new SimpleUser("jendoubi", new
		 * Address("61490", "Tunis", "Tunisie", 0, 0), "25497002",
		 * Gender.Male)); serviceLocal.getSimpleUserEjb().add( new
		 * SimpleUser("SeifAllah Mhadhbi", new Address("1", "Cartage",
		 * "Tunisie", 0, 0), "25947116", Gender.Male));
		 */
		// addCategory();
		// addRestaurantExemple();

		//System.out.println(restaurant.verifAndAssignRestaurant("wgShSxDp", 3));

		System.out.println("End init");
	}

	public void addRestaurantExemple() {
		List<Restaurant> restaurants = foursquareLocal
				.findVenuesByNear("Tunis");

		for (Restaurant restaurant : restaurants) {
			serviceLocal.getRestaurantEjb().add(restaurant);
		}
	}

	public void addCategory() {
		List<Category> categories = foursquareLocal.findAllCategory();
		for (Category category : categories) {
			serviceLocal.getCategoryEjb().add(category);
		}
		System.out.println("-- end synchronise category");
	}
}
