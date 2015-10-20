package utility;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@LocalBean
public class SynchoniseDataFoursquare {

	@Resource
	private TimerService timerService;

	@Schedule(persistent = true, minute = "*", hour = "*", info = "myTimer")
	public void execute(Timer timer) {
		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Execution Time : " + new Date());
	}

}
