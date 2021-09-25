package com.hibernate.joinqueries;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JoinQueryExample {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		College college1 = new College();
		college1.setId(1);
		college1.setName("Engg College");
		
		
		Department dept1 = new Department();
		dept1.setId(1);
		dept1.setName("Computer Engg");
		
		Department dept2 = new Department();
		dept2.setId(2);
		dept2.setName("Mechanical Engg");
		
		List<Department> deptList = new ArrayList<Department>();
		deptList.add(dept1);
		deptList.add(dept2);
		
		college1.setDeptList(deptList);
		
		
		dept1.setCollege(college1);
		dept2.setCollege(college1);
		
		
		Department dept3 = new Department();
		dept3.setId(3);
		dept3.setName("Maths");
		
		Department dept4 = new Department();
		dept4.setId(4);
		dept4.setName("Animation");
		
		List<Department> deptList2 = new ArrayList<Department>();
		deptList2.add(dept3);
		deptList2.add(dept4);
		
		College college2 = new College();
		college2.setId(2);
		college2.setName("Creative College");
		college2.setDeptList(deptList2);
		
		dept3.setCollege(college2);
		dept4.setCollege(college2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(college1);
		session.save(college2);
		session.save(dept1);
		session.save(dept2);
		session.save(dept3);
		session.save(dept4);
		
		tx.commit();
		
		
		
		session.close();
		
	}

}
