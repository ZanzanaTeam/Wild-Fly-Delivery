package utility;

import fi.foyt.foursquare.api.FoursquareApi;

/**
 * 
 * @author Medaymen
 *
 */
public class FoursquareUtility {

	private static final String CLIENT_ID = "DWHLE1OQJBM2HENXFNAR1CGPOEYTCEKHRSF5AV5ZXGD5ZT1Q";
	private static final String CLIENT_SECRET = "P5AKFTGQUJQSYOZMI02KO4H55ZBP1JGQ3CELF44YR2S3XF4D";
	private static final String REDIRECT_URL = "http://localhost/";

	public static FoursquareApi getFoursquareApi() {
		return new FoursquareApi(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL);
	}
}
