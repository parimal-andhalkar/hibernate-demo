package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;

public class App {
	public static void main(String[] args) throws IOException {
		
		//@Entity, @Id, @Table @Column  Annotations
		
		
		System.out.println("Project Started...........");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		/*
		 * Map<String, Object> properties = factory.getProperties(); Set<Entry<String,
		 * Object>> entrySet = properties.entrySet(); for(Entry<String, Object> entry :
		 * entrySet) {
		 * System.out.println("Properties : "+entry.getKey()+"  "+entry.getValue()); }
		 */
		
		
		Student st = new Student();
		st.setId(2);
		st.setName("Ram");
		st.setCity("Nashik");
		
		Student st1 = new Student();
		st1.setId(3);
		st1.setName("Shyam");
		st1.setCity("Nashik");
		


		Address ad = new Address();
		ad.setAddessId(12);
		ad.setCity("Nashik");
		ad.setOpen(true);
		ad.setStreet("Street 1");
		ad.setX(12.25);
		ad.setAddedDate(new Date());

		FileInputStream fis = new FileInputStream("src/main/java/images.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (Exception e) {
			System.out.println(".....................CurrentSession does not exist, opening session............" + e);
			session = factory.openSession();
		}
	
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(st1);
		session.save(ad);
		tx.commit();
		session.close();
	}
}