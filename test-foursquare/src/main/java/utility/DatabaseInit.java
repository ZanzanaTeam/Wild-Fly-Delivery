package utility;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@LocalBean
@Startup
public class DatabaseInit {

	
	@PostConstruct
	public void initDb() {
		System.out.println("initDB");	
	}

}
