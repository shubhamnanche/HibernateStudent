package com.ssk.HibernateDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	public static void main(String[] args) {
		System.out.println("Project started!");

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Student st = new Student();
		st.setName("Shubham");
		st.setCity("Mumbai");
		System.out.println(st);
		
		Address ad = new Address();
		ad.setStreet("Street 1");
		ad.setCity("Mumbai");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.12345);
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("./src/main/java/MyImage.jpg");
			ad.setImage(fis.readAllBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.persist(st);
		session.persist(ad);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done...");
	}
}
