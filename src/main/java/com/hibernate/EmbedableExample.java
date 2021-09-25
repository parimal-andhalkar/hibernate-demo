package com.hibernate;

import java.io.IOException;

import javax.persistence.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Person;

public class EmbedableExample {

	// @Embeddable  Annotations
	
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Person p = new Person();

		p.setId(2);
		p.setName("Parimal");

		Course c = new Course();
		c.setLevel("Easy");
		c.setCname("Java");

		p.setCourse(c);

		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (Exception e) {
			System.out.println(".....................CurrentSession does not exist, opening session............" + e);
			session = factory.openSession();
		}
		

		Transaction tx = session.beginTransaction();
		session.save(p);

		tx.commit();
		session.close();

	}
}
