package com.hibernate.oneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class BusinessPerson {

	@Id
	private int id;

	private String name;

	@OneToMany(mappedBy = "businessPerson")    // mapping is sone by cars table , field marked "businessPerson"
	List<Car> cars;								// if we removed mappedBy extra table is created					

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

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

}
