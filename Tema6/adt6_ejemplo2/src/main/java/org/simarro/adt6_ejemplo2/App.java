package org.simarro.adt6_ejemplo2;

import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {

		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		
        Personaje personaje1 = new Personaje("Mario Bros", 100, 110);
        Arma arma1 = new Arma("Fusil", "AK45", 100);
        
        personaje1.setArma(arma1);
        arma1.setPersonaje(personaje1);
        
        
		// Da de alta el objeto en la tabla de datos
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		
		session.save(personaje1);
		//session.save(arma1);
		
		session.getTransaction().commit();
		session.close(); 
    
    
    
    }
}
