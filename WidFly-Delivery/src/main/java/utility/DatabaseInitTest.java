package utility;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Category;
import entities.SimpleUser;
import entities.embedded.Address;
import entities.enumeration.Gender;
import services.interfaces.FoursquareServiceLocal;
import services.interfaces.basic.FactoryServiceLocal;

@Singleton
@LocalBean
@Startup
public class DatabaseInitTest {

	@EJB
	FactoryServiceLocal serviceLocal;
	@EJB
	FoursquareServiceLocal foursquareLocal;
	
	@PostConstruct
	public void initDb() {
		System.out.println("Begin init");
		serviceLocal.getSimpleUserEjb().add(new SimpleUser("jendoubi", new Address("61490", "Tunis",
						"Tunisie", 0, 0), "25497002",
						"medaymenjendoubi@gmail.com", Gender.Male));
		
		List<Category> categories = foursquareLocal.findAllCategory();
		
		for(Category category : categories){
			serviceLocal.getCategoryEjb().add(category);
		}
		
		System.out.println("End init");
	}

}
