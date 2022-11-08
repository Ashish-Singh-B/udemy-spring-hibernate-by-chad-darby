package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student newStudent = new Student("Ashish", "Singh", "ashish.bh.singh@oracle.com");

			// begin transaction
			session.beginTransaction();
			
			// save student
			System.out.println("Saving Student data ");
			session.save(newStudent);
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Student data saved");
		}finally {
			sessionFactory.close();
		}
	}

}
