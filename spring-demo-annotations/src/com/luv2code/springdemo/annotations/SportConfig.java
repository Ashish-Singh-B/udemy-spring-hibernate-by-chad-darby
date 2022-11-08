package com.luv2code.springdemo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//Define a bean for Sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	//Define a bean for Swim Coach and inject dependency
	@Bean("theSadSwimCoach")
	@Scope("prototype")
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
