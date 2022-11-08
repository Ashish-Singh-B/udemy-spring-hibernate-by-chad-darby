package com.luv2code.springdemo.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	public TennisCoach() {
		//Empty Constructor to stop constructor autowiring for fortuneService
		System.out.println("Tennis Coach ->> Inside default constructor ");
	}

	/*
	 * public TennisCoach(FortuneService fortuneService) { this.fortuneService =
	 * fortuneService; }
	 */
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	@PostConstruct
	public void doSomeInitStuff() {
		System.out.println("Tennis Coach ->> Inside Post Construct/Init method");
	}
	
	@PreDestroy
	public void doCleanUpStuff() {
		System.out.println("Tennis Coach ->> Inside Pre-destroy/Cleanup method");
	}

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println("Tennis Coach ->> Inside setFortuneService()");
	 * this.fortuneService = fortuneService; }
	 */
	
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println("Tennis Coach ->> Inside doSomeCrazyStuff()");
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice the back-hand smash for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
