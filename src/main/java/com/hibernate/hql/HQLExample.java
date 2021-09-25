package com.hibernate.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.joinqueries.College;
import com.hibernate.joinqueries.Department;

public class HQLExample {
	
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
		tx = session.beginTransaction();
		College college4 = new College();
		college4.setId(4);
		college4.setName("Arch College");
		session.save(college4);
		tx.commit();
		
		
		System.out.println("------------------- Select Query Single Row Result------------------------------------");
		String query = "From College as c where c.id =:x and c.name=:y";
		Query hqlQuery = session.createQuery(query);
		hqlQuery.setParameter("x", 1);
		hqlQuery.setParameter("y", "Engg College");
		
		College college = (College) hqlQuery.uniqueResult();  // for unique row;
	
		System.out.println("College  : "+college.getName());
		
		
		query = "From College";
		Query hqlQuery1 = session.createQuery(query);
		List<College> list = hqlQuery1.list();			// for multiple row output
		System.out.println("------------------- Select Query Multiple Rows Result------------------------------------");
		for(College cc :list)
		{
			System.out.println("College  : "+cc.getName());
		}
		
		
		
		
		// update Query
			tx = session.beginTransaction();
			query = "update College as c set c.name=:collegeName where c.id =:id";
			Query query2 = session.createQuery(query);
			query2.setParameter("id", 4);
			query2.setParameter("collegeName", "Pharmcy College");
			int rowsUpdated = query2.executeUpdate();
			System.out.println(rowsUpdated+" rows updated");
		
			//	tx.commit();
			session.close();
			
			//new Session open to get updated result
			session = sessionFactory.openSession();
			
			System.out.println("------------------- Update Query Result------------------------------------");
			query = "From College as c where c.id =:x";
			hqlQuery = session.createQuery(query);
			hqlQuery.setParameter("x", 4);
			College college5 = (College) hqlQuery.uniqueResult();  // for unique row;
			System.out.println("College  : "+college5.getName());  
		
			tx = session.beginTransaction();
			System.out.println("------------------- Delete Query------------------------------------");
			query = "delete From College as c where c.id =:x";
			hqlQuery = session.createQuery(query);
			hqlQuery.setParameter("x", 4);
			int count = hqlQuery.executeUpdate();  // for unique row;
			System.out.println(count+" rows deleted");
			
		
	}
}
