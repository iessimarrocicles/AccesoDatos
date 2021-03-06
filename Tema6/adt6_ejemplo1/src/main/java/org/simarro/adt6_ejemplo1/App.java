package org.simarro.adt6_ejemplo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		
		// Código Legacy
		// Inicializamos un objeto SessionFactory con la configuración hibernate.cfg.xml
		// SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// Inicialización del SessionFactory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		// Iniciamos una sesión
		Session session = sf.openSession();

		// Construimos un objeto de tipo User
		User user1 = new User();
		user1.setId(1);
		user1.setUserName("Pepe");
		user1.setUserMessage("Hello world from Pepe");

		// Construimos otro objeto de tipo User
		User user2 = new User();
		user2.setId(2);
		user2.setUserName("Juan");
		user2.setUserMessage("Hello world from Juan");

		// Iniciamos una transacción dentro de la sesión
		session.beginTransaction();

		// Almacenamos los objetos
		session.save(user1);
		session.save(user2);

		// Commiteamos la transacción
		session.getTransaction().commit();

		// Cerramos todos los objetos
		session.close();
		sf.close();
	}
}