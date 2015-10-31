package services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.json.JSONException;
import org.json.JSONObject;

import services.interfaces.FoursquareServiceLocal;
import utility.FoursquareUtility;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Category;

/**
 * Session Bean implementation class FoursquareService
 */
@Stateless
public class FoursquareService implements FoursquareServiceLocal {

	private FoursquareApi foursquareApi;
	private final String CATEGORY_FOOD = "4d4b7105d754a06374d81259";

	public FoursquareService() {
		foursquareApi = FoursquareUtility.getFoursquareApi();
	}

	@Override
	public List<entities.Category> findAllCategory() {
		List<entities.Category> categories = null;

		try {
			Result<Category[]> result = foursquareApi.venuesCategories();
			System.out.println("Resultat Code : " + result.getMeta().getCode());
			if (result.getMeta().getCode() == 200) {

				if (result.getResult().length > 0)
					categories = new ArrayList<entities.Category>();

				for (Category category : result.getResult()) {
					if (category.getId().equalsIgnoreCase(CATEGORY_FOOD)) {
						Category[] cat = category.getCategories();

						for (int i = 0; i < cat.length; i++) {

							String icon = "";
							try {
								JSONObject json = new JSONObject(
										cat[i].getIcon());
								icon = json.get("prefix") + cat[i].getId()
										+ json.get("suffix");
							} catch (JSONException e) {

							}

							categories.add(new entities.Category(
									cat[i].getId(), cat[i].getName(), icon));
						}
					}
				}
			} else {

				System.out.println("Error occured: "
						+ result.getMeta().getCode());

			}

		} catch (FoursquareApiException e) {

			System.err.println("Category foursquare Erreur");
		}

		return categories;
	}

}
