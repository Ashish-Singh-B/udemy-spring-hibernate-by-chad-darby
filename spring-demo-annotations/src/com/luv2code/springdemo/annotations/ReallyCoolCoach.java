package com.luv2code.springdemo.annotations;

public class ReallyCoolCoach implements Coach {

	private FortuneService fortuneService;
	
	ReallyCoolCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do whatever you like doing! ";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
