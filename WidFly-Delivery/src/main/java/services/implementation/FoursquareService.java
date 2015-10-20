package services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import services.interfaces.FoursquareServiceLocal;
import services.interfaces.FoursquareServiceRemote;
import utility.FoursquareUtility;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Category;
import fi.foyt.foursquare.api.entities.CompleteUser;

/**
 * Session Bean implementation class FoursquareService
 */
@Stateless
public class FoursquareService implements FoursquareServiceRemote,
		FoursquareServiceLocal {

	private FoursquareApi foursquareApi;
	private final String CATEGORY_FOOD = "4bf58dd8d48988d1e0931735";

	public FoursquareService() {
		foursquareApi = FoursquareUtility.getFoursquareApi();
	}

	public CompleteUser getUserAuthenticated() {
		try {

			return foursquareApi.user("self").getResult();
		} catch (FoursquareApiException e) {
			return null;
		}
	}

	public void confirmAuthentification(String code) {
		try {
			foursquareApi.authenticateCode(code);
		} catch (FoursquareApiException e) {

		}
	}

	public String getUrlAuthentification() {
		return foursquareApi.getAuthenticationUrl();
	}

	@Override
	public List<entities.Category> findAllCategory() {
		List<entities.Category> categories = null;

		try {
			Result<Category[]> result = foursquareApi.venuesCategories();

			if (result.getMeta().getCode() == 200) {

				if (result.getResult().length > 0)
					categories = new ArrayList<entities.Category>();

				for (Category category : result.getResult()) {
					if (category.getId().equalsIgnoreCase(CATEGORY_FOOD)) {
						Category[] cat = category.getCategories();

						for (int i = 0; i < cat.length; i++) {
							System.out.print(cat[i].getName() + "\n");

							categories.add(new entities.Category(
									cat[i].getId(), cat[i].getName(), cat[i]
											.getIcon()));
						}
					}
				}
			} else {

				System.out.println("Error occured: ");
				System.out.println("  code: " + result.getMeta().getCode());
				System.out
						.println("  type: " + result.getMeta().getErrorType());
				System.out.println("  detail: "
						+ result.getMeta().getErrorDetail());
			}

		} catch (FoursquareApiException e) {
			e.printStackTrace();
			System.err.println("Category foursquare Erreur");
		}

		return categories;
	}

}
