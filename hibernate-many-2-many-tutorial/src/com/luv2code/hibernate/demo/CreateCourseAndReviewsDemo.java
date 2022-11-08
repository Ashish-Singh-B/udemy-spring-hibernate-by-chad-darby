package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			//create a course
			Course course = new Course("Pacman - The ultimate guide");
			
			//add the reviews
			course.addReview(new Review("Did a great job there!"));
			course.addReview(new Review("Great Course - loved it!"));
			course.addReview(new Review("what a dumb course!"));
			
			// save student
			System.out.println("Saving Course & Reviews data ");

			session.save(course);
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Data saved!");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
