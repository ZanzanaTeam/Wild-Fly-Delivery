package delegate;

import locator.ServiceLocator;
import services.interfaces.basic.FactoryServiceRemote;

public class EntityServicesBasicDelegate {
	public static final String jndiName = "/WidFly-Delivery/FactoryService!services.interfaces.basic.FactoryServiceRemote";

	public static FactoryServiceRemote getProxy() {
		return (FactoryServiceRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static FactoryServiceRemote doCrud() {
		return getProxy();
	}
}