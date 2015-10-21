package test;

import java.util.Scanner;

import delegate.FoursquareAuthServicesDelegate;
import delegate.OwnerServicesBasicDelegate;
import entities.Owner;
import entities.embedded.Address;
import fi.foyt.foursquare.api.entities.CompleteUser;

public class FoursquareAuth {

	public static void main(String[] args) {

		System.out.println(FoursquareAuthServicesDelegate
				.getUrlAuthentification());
		Scanner scanner = new Scanner(System.in);
		String code = scanner.nextLine();
		String oAuthToken = FoursquareAuthServicesDelegate
				.confirmAuthentification(code);

		CompleteUser completeUser = FoursquareAuthServicesDelegate
				.getUserAuthenticated();

		if (oAuthToken != null) {
			Owner owner = new Owner(completeUser.getFirstName() + " "
					+ completeUser.getLastName(), new Address(
					completeUser.getHomeCity(), "", "", 0, 0),
					completeUser.getId(), oAuthToken);
			OwnerServicesBasicDelegate.doCrud().add(owner);
			System.out.println("Vous êtes connecté "
					+ completeUser.getFirstName());

		} else {
			System.out.println("Connexion est echouée");
		}
		scanner.close();
	}
}
