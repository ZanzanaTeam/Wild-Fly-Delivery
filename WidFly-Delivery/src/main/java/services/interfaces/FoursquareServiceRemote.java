package services.interfaces;

import javax.ejb.Remote;

import fi.foyt.foursquare.api.entities.CompleteUser;

@Remote
public interface FoursquareServiceRemote {

	String getUrlAuthentification();
	void confirmAuthentification(String code);
	CompleteUser getUserAuthenticated();
	
	
	
}
