package delegate;

import entities.SimpleUser;
import locator.ServiceLocator;
import services.interfaces.basic.ServicesBasicRemote;

public class SimpleUserServicesBasicDelegate {
	public static final String jndiName = "/WidFly-Delivery/ServicesBasic!services.interfaces.basic.ServicesBasicRemote";

	public static ServicesBasicRemote<SimpleUser> getProxy() {
		return (ServicesBasicRemote<SimpleUser>) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static ServicesBasicRemote<SimpleUser> doCrud() {
		return getProxy();
	}
}