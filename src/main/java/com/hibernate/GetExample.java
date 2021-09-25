package com.hibernate;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class GetExample {

	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (Exception e) {
			System.out.println(".....................CurrentSession does not exist, opening session............" + e);
			session = factory.openSession();
		}
		

		Student student = session.get(Student.class, 2);
		System.out.println("Student Name : "+student.getName());
		
		
		Student student1 = session.get(Student.class, 3);
		System.out.println("Student :"+student1);


		session.close();
		factory.close();

	}

}
