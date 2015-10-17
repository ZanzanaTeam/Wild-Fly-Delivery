package services.interfaces;

import javax.ejb.Local;

import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;

@Local
public interface BasicExampleLocal<T> {
	
	Result<T> searchRestaurant(String location) throws FoursquareApiException;
}
