package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface WildflyHelloRemote {
	
	void testHello (String chaine) ;

}
