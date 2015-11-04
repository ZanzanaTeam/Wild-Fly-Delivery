package test.basic;

import delegate.ServicesBasicDelegate;
import entities.SimpleUser;
import entities.embedded.Address;
import entities.enumeration.Gender;

public class TestCrud {

	public static void main(String[] args) {

		new ServicesBasicDelegate<SimpleUser>().doCrud().add(
				new SimpleUser("jendoubi", new Address("61490", "Tunis",
						"Tunisie", 0, 0), "25490002", Gender.Male));

		new ServicesBasicDelegate<SimpleUser>().doCrud().add(
				new SimpleUser("SeifAllah Mhadhbi", new Address("1", "Cartage",
						"Tunisie", 0, 0), "75947116", Gender.Male));

		System.out.println("Menu = " );
	}

}
