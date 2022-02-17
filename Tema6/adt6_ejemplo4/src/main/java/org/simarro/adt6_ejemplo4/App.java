package org.simarro.adt6_ejemplo4;

import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {
    	HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		
		Arma arma1 = new Arma("Fusil", "AK45", 100);
		Arma arma2 = new Arma("Revólver", "RS10", 50);
		
		Personaje personaje1 = new Personaje("Mario", 100, 110);
		Personaje personaje2 = new Personaje("Luigi", 100, 110);
		
		arma1.getPersonajes().add(personaje1);
		arma1.getPersonajes().add(personaje2);
		
		personaje1.getArmas().add(arma1);
		personaje2.getArmas().add(arma1);
		
		/* Opción 1 */
		/*
		List<Personaje> listaPersonajes = new ArrayList<Personaje>();
		listaPersonajes.add(new Personaje("Mario", 100, 110));
		listaPersonajes.add(new Personaje("Luigi", 100, 110));
		listaPersonajes.add(new Personaje("Yoshi", 100, 110));
		listaPersonajes.add(new Personaje("Waluigi", 100, 110));
		
		arma1.setPersonajes(listaPersonajes);
		
		
		/* Opción 2 
		Personaje personaje1 = new Personaje("Mario", 100, 110);
		Personaje personaje2 = new Personaje("Luigi", 100, 110);
		personaje1.setArma(arma1);
		personaje2.setArma(arma1);
		*/
		// Da de alta el objeto en la tabla de datos
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		
		
		/* Opción 2 */
		session.save(arma1);
		session.save(arma2);
		
		session.getTransaction().commit();
		session.close(); 
    }
}
