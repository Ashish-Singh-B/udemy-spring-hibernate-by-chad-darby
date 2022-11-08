package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;

public class CreateDemo {

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
			// create student object
			System.out.println("Creating new Instructor object ");
			
			
			Instructor instructor = new Instructor("Ashish", "Singh", "ashish.bh.singh@oracle.com");
			InstructorDetails instructorDetail = new InstructorDetails("http://www.udemy.com/ashishbsingh", "Luv 2 code!!!!");
			instructor.setInstructorDetails(instructorDetail);
			
			
			
			/*
			 * Instructor instructor = new Instructor("Madhu", "Patel",
			 * "madhu.patel@oracle.com"); InstructorDetails instructorDetail = new
			 * InstructorDetails("http://www.udemy.com/madhu.patel", "GuitarInstructor");
			 * instructor.setInstructorDetails(instructorDetail);
			 */
			
			// begin transaction
			session.beginTransaction();
			
			// save student
			System.out.println("Saving Instructor & InstructorDetail data ");
			/**
			 * This will save the instructor detail along with Instructor
			 * because we have configured CASCADE TYPE as ALL so instructor save call will save instructor detail
			 */
			
			session.save(instructor);
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Student data saved");
		}finally {
			sessionFactory.close();
		}
	}

}
