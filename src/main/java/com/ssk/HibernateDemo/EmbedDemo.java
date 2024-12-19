package com.ssk.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setName("Raju");
		student1.setCity("Pune");

		Certificate certi1 = new Certificate();
		certi1.setCourse("Android");
		certi1.setDuration("2 months");

		student1.setCertificate(certi1);

		Student student2 = new Student();
		student2.setName("Raju");
		student2.setCity("Pune");

		Certificate certi2 = new Certificate();
		certi2.setCourse("Android");
		certi2.setDuration("2 months");

		student2.setCertificate(certi2);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(student1);
		session.persist(student2);

		tx.commit();

		session.close();
		factory.close();

	}
}
