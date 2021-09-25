package com.hibernate.oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyExample {

	public static void main(String[] args) {
	//	mappedBy
	//	The field that owns the relationship. Required unless the relationship is unidirectional.
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		BusinessPerson p1 = new BusinessPerson();
		p1.setId(1);
		p1.setName("Rajesh");
		
		Car car1 = new Car();
		car1.setId(1);
		car1.setModel("dZire");
		car1.setBusinessPerson(p1);
		
		Car car2 = new Car();
		car2.setId(2);
		car2.setModel("POLO");
		car2.setBusinessPerson(p1);
		
		Car car3 = new Car();
		car3.setId(3);
		car3.setModel("Creta");
		car3.setBusinessPerson(p1);
		
		List<Car> carList = new ArrayList<Car>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		
		
		p1.setCars(carList);
		
		Session session = sessionFactory.openSession();
		Transaction tX = session.beginTransaction();
		session.save(p1);
		session.save(car1);
		session.save(car2);
		session.save(car3);
		
		tX.commit();
		session.close();
	}

}
