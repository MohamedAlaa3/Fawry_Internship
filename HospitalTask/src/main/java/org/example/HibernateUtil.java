package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory factory;

	private HibernateUtil() {
	}

	public static synchronized SessionFactory getSessionFactory() {

		if (factory == null) {
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Doctor.class)
					.addAnnotatedClass(Drug.class)
					.addAnnotatedClass(Patient.class)
					.addAnnotatedClass(Hospital.class)
					.buildSessionFactory();
		}
		return factory;
	}
}