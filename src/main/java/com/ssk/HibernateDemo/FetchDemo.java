package com.ssk.HibernateDemo;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// get, load

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Student student = (Student) session.get(Student.class, 1);
		System.out.println(student);

		try {
			//load will throw exception if object is not found
			Student student2 = (Student) session.load(Student.class, 1);
			System.out.println(student2);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}

		session.close();
		factory.close();
	}

}
