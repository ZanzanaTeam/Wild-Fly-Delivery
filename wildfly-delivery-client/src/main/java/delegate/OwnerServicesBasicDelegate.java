package delegate;

import locator.ServiceLocator;
import services.interfaces.basic.ServicesBasicRemote;
import entities.Owner;

public class OwnerServicesBasicDelegate {
	public static final String jndiName = "/WidFly-Delivery/ServicesBasic!services.interfaces.basic.ServicesBasicRemote";

	public static ServicesBasicRemote<Owner> getProxy() {
		return (ServicesBasicRemote<Owner>) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public static ServicesBasicRemote<Owner> doCrud() {
		return getProxy();
	}
}