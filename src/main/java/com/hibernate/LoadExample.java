package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class LoadExample {

	public static void main(String[] args) {
		System.out.println("Project Started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student st = new Student();

		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (Exception e) {
			System.out.println(".....................CurrentSession does not exist, opening session............" + e);
			session = factory.openSession();
		}
		

		Student student = session.load(Student.class, 2);
		System.out.println("Student Name : "+student.getName());
		
		Student student3 = session.load(Student.class, 3);
		System.out.println("Student :"+student3);
	
		 // gives Exception in thread "main" org.hibernate.ObjectNotFoundException:
	//	Student student11 = session.load(Student.class, 11);  
	//	System.out.println(student11);


		session.close();
		factory.close();

	}

}
