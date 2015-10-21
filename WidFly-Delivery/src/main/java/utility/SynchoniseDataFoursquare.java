package utility;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import services.interfaces.FoursquareServiceLocal;
import services.interfaces.basic.FactoryServiceLocal;
import utility.enumeration.TimerName;
import entities.Category;

@Singleton
@LocalBean
@Startup
public class SynchoniseDataFoursquare {

	@Resource
	private TimerService timerService;
	@EJB
	FactoryServiceLocal serviceLocal;
	@EJB
	FoursquareServiceLocal foursquareLocal;

	@PostConstruct
	public void init() {
		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setInfo(TimerName.SynchroniseData.name());
		ScheduleExpression schedule = new ScheduleExpression();
		schedule.dayOfWeek("1").hour("00").minute("00");
		timerService.createCalendarTimer(schedule, timerConfig);
	}

	@Timeout
	public void execute(Timer timer) {

		System.out.println("** Timer Service : " + timer.getInfo()
				+ "\n Execution Time : " + new Date());
		synchroniseCategory();
		synchroniseRestaurant();
		System.out.println("** End Synchronise Data");
	}

	public void stop(String timerName) {
		for (Object obj : timerService.getTimers()) {
			Timer t = (Timer) obj;
			if (t.getInfo().equals(timerName)) {
				t.cancel();
			}
		}
	}

	public void synchroniseCategory() {
		List<Category> categories = foursquareLocal.findAllCategory();
		for (Category category : categories) {
			serviceLocal.getCategoryEjb().add(category);
		}
		System.out.println("-- end synchronise category");
	}

	public void synchroniseRestaurant() {
		// on va spécifier les restaurant conforme dans cette methode
		// -- sénario de test : si on a des menus / zone de livraison (dans
		// notre data), on va
		// considérer comme un restaurant conforme sinn non conforme
		
		//
		System.out.println("-- end synchronise restaurant");
	}
}
