package test;

import java.util.Scanner;

import delegate.RestaurantServiceDelegate;

public class TestDemandeOwner {

	public static Integer OWNER_ID = 6;
	public static String RESTAURANT_ID = "4b52d9a0f964a5203f8927e3";//"4b52d9a0f964a5203f8927e3";

	public static void main(String[] args) {

		RestaurantServiceDelegate delegate = new RestaurantServiceDelegate();

		if (delegate.demandeOwner(RESTAURANT_ID, OWNER_ID)) {

			Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez votre code reçu par mail :");
			String code = scanner.nextLine();

			if (delegate.AssignRestaurant(code, OWNER_ID)) {
				System.out.println("Votre restaurant est bien vérifier Merci !"
						+ " \n -- Vous pouvez passer à la etape suivante.");
			}
			
			scanner.close();

		} else {

			System.out
					.println("Vous êtes pas autorisé pour cette interface !! ");
		}
		
		
	}
}
