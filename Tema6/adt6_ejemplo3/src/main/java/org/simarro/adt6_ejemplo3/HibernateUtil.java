package org.simarro.adt6_ejemplo3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;

	// Crea la factoría de sesiones
	public static void buildSessionFactory() {
		// Inicialización del SessionFactory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
	}

	// Abre una nueva sesión
	public static void openSession() {
		session = sessionFactory.openSession();
	}

	// Devuelve la sesión actual
	public static Session getCurrentSession() {
		if (!session.isOpen())
			openSession();
		return session;
	}

	// Cierra Hibernate
	public static void closeSessionFactory() {
		if (session != null)
			session.close();
		if (sessionFactory != null)
			sessionFactory.close();
	}
}