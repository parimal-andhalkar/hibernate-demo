package com.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Course {

	String cname;
	String level;
	
		
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}