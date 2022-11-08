package com.luv2code.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml"); 
		
		// retrieve the bean from spring container
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean isSameObject = theCoach == alphaCoach;
		System.out.println("Is Same coach: " + isSameObject);
		System.out.println("Memory location of The Coach  : " + theCoach);
		System.out.println("Memory location of Alpha Coach: " + alphaCoach);
		
		// close the context
		context.close();
	}

}
