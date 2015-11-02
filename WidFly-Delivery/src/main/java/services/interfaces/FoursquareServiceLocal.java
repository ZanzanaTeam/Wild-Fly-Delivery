package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Category;
import entities.Restaurant;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

@Local
public interface FoursquareServiceLocal {
	
	List<Category> findAllCategory();
	List<Restaurant> findVenuesByNear(String near);
	
}
