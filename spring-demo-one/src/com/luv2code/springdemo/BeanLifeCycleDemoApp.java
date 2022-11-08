package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("beanlifecycle-applicationContext.xml"); 
		
		// retrieve the bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		
		// call methods on the bean 
		System.out.println(theCoach.getDailyWorkout());
		  
		// call methods on the bean 
		System.out.println(theCoach.getDailyFortune());
		 
		
		// close the context
		context.close();

	}

}
