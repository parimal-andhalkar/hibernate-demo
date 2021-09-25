package com.hibernate.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneexample {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		Question que = new Question();
		que.setqId(1);
		que.setQue("Best Programming Language ?");

		Answer ans = new Answer();
		ans.setaId(1);
		ans.setAns("Java");
		que.setAnswer(ans);

		
		Question que1 = new Question();
		que1.setqId(2);
		que1.setQue("Best Book for Algorithm ?");

		Answer ans1 = new Answer();
		ans1.setaId(2);
		ans1.setAns("DAA");
		que1.setAnswer(ans1);
		Transaction transaction = session.beginTransaction();
		session.save(que);
		session.save(ans);

		session.save(que1);
		session.save(ans1);
		transaction.commit();
		
		Question question = session.get(Question.class, 1);
		System.out.println("Question 1: "+question.getQue());
		System.out.println("Answer 1:"+question.getAnswer().getAns());
		
		
		Question question2 = session.get(Question.class, 2);
		System.out.println("Question 2: "+question2.getQue());
		System.out.println("Answer 2:"+question2.getAnswer().getAns());
		
		
		// This result is from cache
		Question question0 = session.get(Question.class, 1);
		System.out.println("Question 1: "+question0.getQue());
		System.out.println("Answer 1:"+question0.getAnswer().getAns());

		session.close();
		
		// here IllegalStateException ..Bcoz session is closed
		/*
		 * question2 = session.get(Question.class, 2);
		 * System.out.println("Question 2: "+question2.getQue());
		 * System.out.println("Answer 2:"+question2.getAnswer().getAns());
		 */
	}

}
