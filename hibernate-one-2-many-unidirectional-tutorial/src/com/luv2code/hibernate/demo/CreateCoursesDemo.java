package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class CreateCoursesDemo {

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
			
			//create courses
			Course course = new Course("Air Guitar - The ultimate guide");
			Course course2 = new Course("Java - Complete reference");
			Course course3 = new Course("Master of Spring");
			Course course4 = new Course("Beginner to Python");
			Course course5 = new Course("Deep Meditation");

			instructor.addCourse(course);
			instructor.addCourse(course2);
			instructor.addCourse(course3);
			instructor.addCourse(course4);
			instructor.addCourse(course5);
			
			
			// save student
			System.out.println("Saving Instructor & InstructorDetail data ");
			/**
			 * This will save the instructor detail along with Instructor
			 * because we have configured CASCADE TYPE as ALL so instructor save call will save instructor detail
			 */
			
			session.save(course);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			session.save(course5);
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Student data saved");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
