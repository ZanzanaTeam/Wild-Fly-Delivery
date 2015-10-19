package test.basic;

import delegate.EntityServicesBasicDelegate;
import delegate.SimpleUserServicesBasicDelegate;
import delegate.TestServer;
import entities.SimpleUser;
import entities.embedded.Address;
import entities.enumeration.Gender;

public class TestCrud {

	public static void main(String[] args) {

		/*EntityServicesBasicDelegate
				.getProxy()
				.getSimpleUserEjb()
				.add(new SimpleUser("jendoubi", new Address("61490", "Tunis",
						"Tunisie", 0, 0), "25497002",
						"medaymenjendoubi@gmail.com", Gender.Male));*/

		SimpleUserServicesBasicDelegate.getProxy().add(
				new SimpleUser("jendoubi", new Address("61490", "Tunis",
						"Tunisie", 0, 0), "25497002",
						"medaymenjendoubi@gmail.com", Gender.Male));

		TestServer.doTest();

	}

}
