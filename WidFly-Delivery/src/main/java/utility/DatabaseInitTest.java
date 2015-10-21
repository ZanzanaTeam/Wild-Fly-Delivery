package utility;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.interfaces.FoursquareServiceLocal;
import services.interfaces.basic.FactoryServiceLocal;
import entities.SimpleUser;
import entities.embedded.Address;
import entities.enumeration.Gender;

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
		serviceLocal.getSimpleUserEjb().add(
				new SimpleUser("jendoubi", new Address("61490", "Tunis",
						"Tunisie", 0, 0), "25497002",
						"medaymenjendoubi@gmail.com", Gender.Male));

		System.out.println("End init");
	}

}
