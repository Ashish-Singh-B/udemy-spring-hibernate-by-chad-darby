package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		// save object
		try {
			// create student object
			System.out.println("Creating new student object ");
			Student newStudent = new Student("Daffy", "Duck", "daffy.duck@oracle.com");

			// begin transaction
			session.beginTransaction();
			
			// save student
			System.out.println("Saving Student data ");
			System.out.println(newStudent);
			session.save(newStudent);
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Student data saved");
			
			// Retrieve the object
			System.out.println("Saved student, Generated ID: " + newStudent.getStudentId());
			

			
			// now get a new session
			session = sessionFactory.getCurrentSession();
			
			// start the transaction
			session.beginTransaction();

			// retrieve the student
			System.out.println("\nFetching student with Id: " + newStudent.getStudentId());
			Student fetchedStudent = session.get(Student.class, newStudent.getStudentId());
			System.out.println("Fetched Student: " + fetchedStudent);
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			sessionFactory.close();
		}
	}

}
