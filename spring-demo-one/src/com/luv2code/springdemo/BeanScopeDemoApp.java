package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("beanscope-applicationContext.xml"); 
		
		// retrieve the bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		// retrieve the same bean from spring container
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean isSameObjects = theCoach == alphaCoach;
		
		System.out.println("Pointing to the same object: " + isSameObjects);
		System.out.println("Memory location of TheCoach object  : " + theCoach);
		System.out.println("Memory location of AplhaCoach object: " + alphaCoach);
		
		/*
		 * // call methods on the bean System.out.println(theCoach.getDailyWorkout());
		 * 
		 * // call methods on the bean System.out.println(theCoach.getDailyFortune());
		 */
		
		// close the context
		context.close();

	}

}
