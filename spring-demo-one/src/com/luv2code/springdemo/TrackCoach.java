package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 10 miles";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	//add a init method
	void doMyInitStuff() {
		System.out.println("Inside Track Coach -> Init method");
	}

	//add a destroy method
	void doMyCleanupStuff() {
		System.out.println("Inside Track Coach -> Destroy method");
	}
}
