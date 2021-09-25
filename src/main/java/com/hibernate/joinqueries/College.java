package com.hibernate.joinqueries;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {

	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "college")
	private List<Department> deptList;

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

	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", deptList=" + deptList + "]";
	}
	
	
	
	
}
