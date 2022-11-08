package com.luv2code.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimBeanConfigDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (SportConfig.class); 
		
		// retrieve the bean from spring container
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		SwimCoach theCoach = context.getBean("theSadSwimCoach", SwimCoach.class);
		//Coach alphaCoach = context.getBean("theSadSwimCoach", Coach.class);
		
		///System.out.println("Is same object " + (theCoach == alphaCoach));
		// call methods on the bean
		
		  System.out.println(theCoach.getDailyWorkout());
		  System.out.println(theCoach.getDailyFortune());
		  System.out.println("Email : " + theCoach.getEmail());
		  System.out.println("Team : " + theCoach.getTeam());
		
		
		// close the context
		context.close();
	}

}
