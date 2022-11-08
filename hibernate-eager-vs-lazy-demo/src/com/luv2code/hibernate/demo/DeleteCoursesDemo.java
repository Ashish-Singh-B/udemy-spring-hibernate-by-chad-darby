package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class DeleteCoursesDemo {

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
			
			// get the course
			int courseIDToDelete = 10;
			Course courseToDelete = session.get(Course.class, courseIDToDelete );
			
			System.out.println("Course to delete: " + courseToDelete);
			
			//delete the course
			session.delete(courseToDelete);
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Course Deleted!");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
