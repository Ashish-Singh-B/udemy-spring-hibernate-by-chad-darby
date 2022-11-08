package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class FetchJoinHQLDemo {

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
			
			Query<Instructor> query = session.createQuery("from Instructor i "
					+ " JOIN FETCH i.courses "
					+ "where i.instructorId=:theInstructorId",
					Instructor.class);
			query.setParameter("theInstructorId", instructorId);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("luv2code: Found Instructor: " + instructor);


			
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
