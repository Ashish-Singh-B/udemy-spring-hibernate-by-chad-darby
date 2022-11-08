package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			// create 3 student object
			System.out.println("Creating 3 new students object ");
			Student newStudent1 = new Student("John", "Doe", "john.doe@oracle.com");
			Student newStudent2 = new Student("Mary", "Public", "mary.public@oracle.com");
			Student newStudent3 = new Student("Bonita", "Jain", "bonita.jain@oracle.com");

			// begin transaction
			session.beginTransaction();
			
			// save student
			System.out.println("Saving Students");
			session.save(newStudent1);
			session.save(newStudent2);
			session.save(newStudent3);
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Students data saved");
		}finally {
			sessionFactory.close();
		}

	}

}
