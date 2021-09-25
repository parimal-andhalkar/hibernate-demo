package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	int id;
	String name;
	
	Course course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}	
}
