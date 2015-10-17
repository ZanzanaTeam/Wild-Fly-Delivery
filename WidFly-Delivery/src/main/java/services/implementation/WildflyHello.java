package services.implementation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import services.interfaces.WildflyHelloLocal;
import services.interfaces.WildflyHelloRemote;

/**
 * Session Bean implementation class WildflyHello
 */
@Stateless
@LocalBean
public class WildflyHello implements WildflyHelloRemote, WildflyHelloLocal {

    /**
     * Default constructor. 
     */
    public WildflyHello() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void testHello(String chaine) {
		System.out.println("ceci est un test" + chaine);
	}

}
