package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetails.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		// save object
		try {
			
			// begin transaction
			session.beginTransaction();
			
			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			System.out.println("luv2code: Found Instructor: " + instructor);

			System.out.println("luv2code: Course taught by Instructor: " + instructor.getCourses());

			
			// commmit transaction
			session.getTransaction().commit();
			
			
			session.close();
			
			System.out.println("\nsession is now closed\n");
			System.out.println("luv2code: Course taught by Instructor: " + instructor.getCourses());
			

			System.out.println("luv2code: done!");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
