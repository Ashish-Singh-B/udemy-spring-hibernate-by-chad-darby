package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetails.class)
										.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		// save object
		try {
			// begin transaction
			session.beginTransaction();
			
			int instId = 2;
			Instructor instructor = session.get(Instructor.class, instId);
			
			System.out.println("Found Instructor: " + instructor);
			
			// save student
			System.out.println("Deleting Instructor & InstructorDetail data ");
			/**
			 * This will delete the instructor_detail along with Instructor
			 * because we have configured CASCADE TYPE as ALL so instructor save call will save instructor detail
			 */
			if(instructor!=null) {
				System.out.println("Deleting Instructor: " + instructor);
				session.delete(instructor);
			}
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			sessionFactory.close();
		}
	}

}
