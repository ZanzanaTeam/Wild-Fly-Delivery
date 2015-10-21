package test.basic;

import delegate.SimpleUserServicesBasicDelegate;
import entities.SimpleUser;
import entities.embedded.Address;
import entities.enumeration.Gender;

public class TestCrud {

	public static void main(String[] args) {

		SimpleUserServicesBasicDelegate.doCrud().add(
				new SimpleUser("jendoubi", new Address("61490", "Tunis",
						"Tunisie", 0, 0), "25497002",
						"medaymenjendoubi@gmail.com", Gender.Male));
		
		SimpleUserServicesBasicDelegate.doCrud().add(
				new SimpleUser("SeifAllah Mhadhbi", new Address("1", "Cartage",
						"Tunisie", 0, 0), "25947116",
						"seifallahmhadhbi@gmail.com", Gender.Male));

	}

}
