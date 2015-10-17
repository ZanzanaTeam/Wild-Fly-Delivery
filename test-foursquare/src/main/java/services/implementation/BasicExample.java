package services.implementation;


import javax.ejb.Stateless;

import services.interfaces.BasicExampleLocal;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Category;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

@Stateless
public class BasicExample<T> implements BasicExampleLocal<T>{


	@Override
	public Result<T> searchRestaurant(String location) throws FoursquareApiException {
		 // First we need a initialize FoursquareApi. 
	    FoursquareApi foursquareApi = new FoursquareApi("DWHLE1OQJBM2HENXFNAR1CGPOEYTCEKHRSF5AV5ZXGD5ZT1Q", "P5AKFTGQUJQSYOZMI02KO4H55ZBP1JGQ3CELF44YR2S3XF4D", "http:\\\\localhost\\");
	    location = "36.857453, 10.208315";
	    
	    // After client has been initialized we can make queries.
	    Result<VenuesSearchResult> result = foursquareApi.venuesSearch(location, null, null, null, null, 100, null, "4bf58dd8d48988d1e0931735", null, null, null, null, null);
	    
	    //result = foursquareApi.venuesSearch("tunis", "", 100, null, "4bf58dd8d48988d1e0931735", null, null, null);
	    
	    //foursquareApi.venuesCategories();
	    
	    if (result.getMeta().getCode() == 200) {
	      // if query was ok we can finally we do something with the data
	      for (CompactVenue venue : result.getResult().getVenues()) {
	        // TODO: Do something we the data
	        System.out.print(venue.getName()+" ("+venue.getCategories().length+")");
	        Category[] categories= venue.getCategories();
	        for(int i =0 ; i< categories.length;i++){
	        	System.out.print(categories[i]+"\t");
	        }
	        System.out.println();
	      }
	    } else {
	      // TODO: Proper error handling
	      System.out.println("Error occured: ");
	      System.out.println("  code: " + result.getMeta().getCode());
	      System.out.println("  type: " + result.getMeta().getErrorType());
	      System.out.println("  detail: " + result.getMeta().getErrorDetail()); 
	    }
	    
	    return null;
	}
}
