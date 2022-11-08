package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeletePacManCourseDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetails.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		// save object
		try {
			
			// begin transaction
			session.beginTransaction();
			
			
			int studentId = 3;
			Student mary = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded Student: "+mary);
			System.out.println("\nEnrolled courses : "+mary.getCourses());
			
			//create courses
			Course course = new Course("Rubik Cube - The ultimate guide");
			Course course1 = new Course("Air Hockey - Play like pro");
			Course course2 = new Course("Master the space man");
			Course course3 = new Course("Begin with Java");
			
			
			
			//add the students
			course.enrollStrudent(mary);
			course1.enrollStrudent(mary);
			course2.enrollStrudent(mary);
			course3.enrollStrudent(mary);
			
			// save student
			System.out.println("Saving Course & Students data ");

			session.save(course);
			session.save(course1);
			session.save(course2);
			session.save(course3);
			// commmit transaction
			session.getTransaction().commit();
			System.out.println("Data saved!");
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
