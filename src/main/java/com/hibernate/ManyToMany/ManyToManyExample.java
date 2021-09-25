package com.hibernate.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyExample {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setEmpName("Ram");
		
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setEmpName("Shyam");
		
		Employee emp3 = new Employee();
		emp3.setId(3);
		emp3.setEmpName("Ganesh");

		Employee emp4 = new Employee();
		emp4.setId(4);
		emp4.setEmpName("Rajesh");
		
		Employee emp5 = new Employee();
		emp5.setId(5);
		emp5.setEmpName("Vijay");
		
		
		Project pr1 = new Project();
		pr1.setProjectId(1);
		pr1.setProjectName("Banking");
		
		Project pr2 = new Project();
		pr2.setProjectId(2);
		pr2.setProjectName("Telecom");
		
		
		
		List<Employee> emplList1 = new ArrayList<Employee>();
		
		emplList1.add(emp1);
		emplList1.add(emp2);
		emplList1.add(emp3);
		emplList1.add(emp4);
		emplList1.add(emp5);
		
		List<Employee> emplList2 = new ArrayList<Employee>();
		emplList2.add(emp2);
		emplList2.add(emp3);
		emplList2.add(emp4);
		
		pr1.setEmpList(emplList1);
		pr2.setEmpList(emplList2);
		
		
		List<Project> projectList1 = new ArrayList<Project>();
		projectList1.add(pr1);
		emp1.setProjectList(projectList1);
		
		List<Project> projectList2 = new ArrayList<Project>();
		projectList2.add(pr1);
		projectList2.add(pr2);
		emp2.setProjectList(projectList2);
		
		List<Project> projectList3 = new ArrayList<Project>();
		projectList3.add(pr2);
		emp3.setProjectList(projectList3);
		
		
		emp4.setProjectList(projectList2);
		Transaction tx = session.beginTransaction();

		session.save(pr1);
		session.save(pr2);
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
	
		tx.commit();
		
		session.close();
	}

}
