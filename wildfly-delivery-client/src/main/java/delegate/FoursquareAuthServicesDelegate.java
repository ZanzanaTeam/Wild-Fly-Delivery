package delegate;

import locator.ServiceLocator;
import services.interfaces.FoursquareServiceRemote;
import services.interfaces.basic.ServicesBasicRemote;
import utility.FoursquareUtility;
import entities.SimpleUser;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.entities.CompleteUser;

public class FoursquareAuthServicesDelegate {
	public static final String jndiName = "/WidFly-Delivery/FoursquareService!services.interfaces.FoursquareServiceRemote";

	public static FoursquareServiceRemote getProxy() {
		return (FoursquareServiceRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public static CompleteUser getUserAuthenticated() {
		return getProxy().getUserAuthenticated();
	}

	public static void confirmAuthentification(String code) {
		getProxy().confirmAuthentification(code);
	}

	public static String getUrlAuthentification() {
		return getProxy().getUrlAuthentification();
	}
}