package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;

public class FetchCourseAndReviewsDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetails.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		// save object
		try {
			
			// begin transaction
			session.beginTransaction();
			
			int courseId = 10;
			Course course = session.get(Course.class, courseId);
			System.out.println("Course: " + course);
			System.out.println("Reviews: " + course.getReviews());
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Data saved!");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
