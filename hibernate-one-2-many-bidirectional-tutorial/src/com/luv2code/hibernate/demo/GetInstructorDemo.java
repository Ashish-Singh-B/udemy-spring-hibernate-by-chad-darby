package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class GetInstructorDemo {

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
			
			int instructorDetailId = 185;
			InstructorDetails instructorDetail = session.get(InstructorDetails.class, instructorDetailId);
			
			System.out.println("Found InstructorDetail: " + instructorDetail);
			System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
		

			// save student
			//System.out.println("Deleting Instructor & InstructorDetail data ");
			/**
			 * This will delete the instructor_detail along with Instructor
			 * because we have configured CASCADE TYPE as ALL so instructor save call will save instructor detail
			 */
			/**
			if(instructorDetail!=null) {
				System.out.println("Deleting Instructor: " + instructorDetail);
				session.delete(instructorDetail);
			}
			*/
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// handle connection leak issue
			session.close();
			sessionFactory.close();
		}
	}

}
