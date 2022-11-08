package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

		// define fields
	// constructor
	//getter & setter
	// tostring
	//annotate fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int course_id ;
	
	@Column(name="title")
	private String courseTitle;
	
	@ManyToOne(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;
	
	
	@ManyToMany(fetch=FetchType.LAZY ,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "course_student",joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> students;
	
	
	
	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Course(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	

	public int getCourse_id() {
		return course_id;
	}



	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	
	
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", courseTitle=" + courseTitle + ", instructor=" + instructor
				+ ", reviews=" + reviews + ", students=" + students + "]";
	}


	public void addReview(Review newReview) {
		if(reviews==null)
			reviews = new ArrayList<Review>();
		reviews.add(newReview);
	}
	
	public void enrollStrudent(Student newStudent) {
		if(students==null)
			students = new ArrayList<Student>();
		students.add(newStudent);
	}
	
}
