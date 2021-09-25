package com.hibernate.oneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	
	@Id
	private int id;
	private String model;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private BusinessPerson businessPerson;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BusinessPerson getBusinessPerson() {
		return businessPerson;
	}

	public void setBusinessPerson(BusinessPerson businessPerson) {
		this.businessPerson = businessPerson;
	}

		
	
}
