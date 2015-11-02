package test;

import java.util.Scanner;

import utility.FoursquareUtility;
import delegate.ServicesBasicDelegate;
import entities.Owner;
import entities.embedded.Address;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.entities.CompleteUser;

public class FoursquareAuth {

	public static void main(String[] args) {
		FoursquareApi foursquareApi = FoursquareUtility.getFoursquareApi();

		System.out.println(foursquareApi.getAuthenticationUrl());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez votre code de passage : ");
		String code = scanner.nextLine();
		try {
			foursquareApi.authenticateCode(code);

			String oAuthToken = foursquareApi.getOAuthToken();

			if (oAuthToken != null) {
				CompleteUser completeUser = foursquareApi.user("self")
						.getResult();

				Owner owner = new Owner(completeUser.getFirstName() + " "
						+ completeUser.getLastName(), new Address(
						completeUser.getHomeCity(), "", "", 0, 0), completeUser
						.getContact().getEmail(), completeUser.getId(),
						oAuthToken);

				new ServicesBasicDelegate<Owner>().doCrud().add(owner);
				System.out.println("Vous êtes connecté "
						+ completeUser.getFirstName());

			} else {
				System.out.println("Connexion est echouée");
			}
		} catch (FoursquareApiException e) {
			System.out.println("Connexion est echouée");
		}
		scanner.close();
	}
}
