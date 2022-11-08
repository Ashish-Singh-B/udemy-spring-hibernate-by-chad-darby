package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		return "Course [id=" + course_id + ", courseTitle=" + courseTitle + "]";
	}
	
	

}
