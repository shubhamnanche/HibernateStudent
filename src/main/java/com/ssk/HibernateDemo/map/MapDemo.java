package com.ssk.HibernateDemo.map;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Question q1 = new Question();
		q1.setQuestionId(101);
		q1.setQuestion("What is Java?");

		Answer a1 = new Answer();
		a1.setAnswerId(123);
		a1.setAnswer("Java is a programming language");
		a1.setQuestion(q1);
		
		Answer a2 = new Answer();
		a2.setAnswerId(124);
		a2.setAnswer("Java is an OOP language");
		a2.setQuestion(q1);

		q1.setAnswers(Arrays.asList(a1, a2));

		Transaction tx = session.beginTransaction();
		session.persist(a1);
		session.persist(a2);
		
		session.persist(q1);
		tx.commit();

		session.close();
		factory.close();
	}

}
