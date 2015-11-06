package Hibernate_maventry.HQL;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilities_HQL {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static{
		try{
			Configuration configuration = new Configuration().configure();
			
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch(HibernateException e){
			System.out.println("Problem creating session factory");	
			System.out.println(e.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
