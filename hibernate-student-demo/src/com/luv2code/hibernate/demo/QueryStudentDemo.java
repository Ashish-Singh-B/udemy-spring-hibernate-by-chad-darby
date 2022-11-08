package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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

			session.beginTransaction();
			
			//Query students
			List<Student> theStudents = session.createQuery("from Student").list();// getResultList();
			
			displayStudents(theStudents);

			//Query students where lastname is Doe
			
			//Query students
			List<Student> doeStudents = session.createQuery("from Student S where S.lastName='Doe'").list();// getResultList();
			// Display queried students
			System.out.println("\nStudents with Doe as last name");
			displayStudents(doeStudents);
			
			//Query students
			List<Student> daffyDoeStudents = session.createQuery("from Student S"
					+ " where S.lastName='Doe' OR S.firstName='daffy'" ).list();// getResultList();
			// Display queried students
			System.out.println("\nStudents with Daffy as Firstname or Doe as last name");
			displayStudents(daffyDoeStudents);
			
			
			//Query students
			List<Student> emailStudents = session.createQuery("from Student S"
					+ " where S.email like '%oracle.com'" ).list();// getResultList();
			// Display queried students
			System.out.println("\nStudents with oracle.com as email domain");
			displayStudents(emailStudents);
			
			
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> doeStudents) {
		for(Student student: doeStudents) {
			System.out.println(student);
		}
	}

}
