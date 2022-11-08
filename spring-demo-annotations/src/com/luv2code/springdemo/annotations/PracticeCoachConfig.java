package com.luv2code.springdemo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.luv2code.springdemo")
public class PracticeCoachConfig {

	@Bean 
	BoringFortuneService boringFortuneService() {
		return new BoringFortuneService();
	}
	
	@Bean
	ReallyCoolCoach realCoolCoach() {
		return new ReallyCoolCoach(boringFortuneService());
	}
}
