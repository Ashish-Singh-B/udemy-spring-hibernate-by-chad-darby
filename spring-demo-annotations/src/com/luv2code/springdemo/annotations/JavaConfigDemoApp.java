package com.luv2code.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (SportConfig.class); 
		
		// retrieve the bean from spring container
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		// close the context
		context.close();
	}

}
