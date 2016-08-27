package com.fei.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateClient {
	
	public static SessionFactory sessionFactory;
	/**
	 * 不管new 多少次 static 都只执行一次
	 */
	static {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		} catch (Throwable ex) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	

}
