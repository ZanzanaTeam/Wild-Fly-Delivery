package utility;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;
import services.interfaces.BasicExampleLocal;

@Singleton
@LocalBean
@Startup
public class DatabaseInit {

	@EJB
	BasicExampleLocal<VenuesSearchResult> basic;
	
	@PostConstruct
	public void initDb() {
		System.out.println("Begin search");
		
		try {
			basic.searchRestaurant("");
		} catch (FoursquareApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
