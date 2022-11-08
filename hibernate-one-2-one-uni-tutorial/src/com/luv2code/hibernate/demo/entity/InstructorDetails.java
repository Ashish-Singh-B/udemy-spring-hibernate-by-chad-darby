package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int instructorDetailsId;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column
	private String hobby;

	public InstructorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public InstructorDetails(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetails [instructorDetailsId=" + instructorDetailsId + ", youtubeChannel=" + youtubeChannel
				+ ", hobby=" + hobby + "]";
	}

	public int getInstructorDetailsId() {
		return instructorDetailsId;
	}

	public void setInstructorDetailsId(int instructorDetailsId) {
		this.instructorDetailsId = instructorDetailsId;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	

}
