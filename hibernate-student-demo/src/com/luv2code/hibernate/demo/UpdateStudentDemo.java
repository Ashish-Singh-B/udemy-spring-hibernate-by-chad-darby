package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		try {
			int studentId = 1;
			
			// now get a new session
			Session session = sessionFactory.getCurrentSession();
			
			// start the transaction
			session.beginTransaction();

			// retrieve the student
			System.out.println("\nFetching student with Id: " + studentId);
			Student fetchedStudent = session.get(Student.class, studentId);
			System.out.println("Fetched Student: " + fetchedStudent);
			
			System.out.println("Updating the student...");
			fetchedStudent.setFirstName("Scooby");

			// commit the transaction
			session.getTransaction().commit();
			
			
			
			
			//Bulk update
			// now get a new session
			Session bulkUpdateSession = sessionFactory.getCurrentSession();
			
			// start the transaction
			bulkUpdateSession.beginTransaction();
			System.out.println("Updating all student email");
			System.out.println("Updated rows: " + bulkUpdateSession.createQuery("update Student set email='default@email.com'").executeUpdate());
			// commit the transaction
			bulkUpdateSession.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}finally {
			sessionFactory.close();
		}
	}

}
