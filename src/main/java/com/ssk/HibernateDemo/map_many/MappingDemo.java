package com.ssk.HibernateDemo.map_many;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Employee e1 = new Employee();
		e1.setEid(1);
		e1.setName("Ram");

		Employee e2 = new Employee();
		e2.setEid(2);
		e2.setName("Shyam");

		Project p1 = new Project();
		p1.setPid(1);
		p1.setProjectName("Library Management System");

		Project p2 = new Project();
		p2.setPid(2);
		p2.setProjectName("Chatbot");

		e1.setProjects(Arrays.asList(p1, p2));
		p2.setEmployees(Arrays.asList(e1, e2));

		Transaction tx = session.beginTransaction();
		session.persist(e1);
		session.persist(e2);
		session.persist(p1);
		session.persist(p2);
		tx.commit();

		session.close();
		factory.close();

	}

}
