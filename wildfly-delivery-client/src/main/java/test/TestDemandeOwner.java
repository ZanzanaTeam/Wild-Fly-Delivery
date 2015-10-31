package test;

import delegate.DemandeOwnerServiceDelegate;

public class TestDemandeOwner {

	public static void main(String[] args) {

		DemandeOwnerServiceDelegate delegate = new DemandeOwnerServiceDelegate();
		delegate.demandeOwner("4b52d9a0f964a5203f8927e3", 3);
	}

}
