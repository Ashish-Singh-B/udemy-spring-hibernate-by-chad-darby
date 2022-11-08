package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private String emailAddress;
	private String team;
	private FortuneService fortuneService; 
	
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside Setter : Email Address of Cricket Coach");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("Inside Setter : Team of Cricket Coach");
		this.team = team;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public CricketCoach() {
		System.out.println("Inside Cricket Coach constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside Setter method of Cricket Coach");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getDailyWorkout() {
		return "Practice batting against fast bouncers bowling for 30 minutes";
	}

}
