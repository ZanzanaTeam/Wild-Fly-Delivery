package delegate;

import locator.ServiceLocator;
import services.interfaces.WildflyHelloRemote;

public class TestServer {

	public static final String jndiName = "/WidFly-Delivery/WildflyHello!services.interfaces.WildflyHelloRemote";

	public static WildflyHelloRemote getProxy() {
		return (WildflyHelloRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void  doTest() {
		 getProxy().testHello("jendoubi");;
	}
}
