package test;

import java.util.Scanner;

import delegate.FoursquareAuthServicesDelegate;

public class FoursquareAuth {

	public static void main(String[] args) {

		System.out.println(FoursquareAuthServicesDelegate
				.getUrlAuthentification());
		Scanner scanner = new Scanner(System.in);
		String code = scanner.nextLine();
		FoursquareAuthServicesDelegate.confirmAuthentification(code);
		System.out.println(FoursquareAuthServicesDelegate
				.getUserAuthenticated().getFirstName());
		scanner.close();
	}

}
