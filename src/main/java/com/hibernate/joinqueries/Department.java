package com.hibernate.joinqueries;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Department {
	
	@Id
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="collegeID")
	private College college;

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

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", college=" + college + "]";
	}
	
}
