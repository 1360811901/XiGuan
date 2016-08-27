package com.fei.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fei.Entity.ContactsList;

public class HibernateTest {
	public static void main(String[] args){
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		ContactsList contacts = new ContactsList();
		Transaction tr = session.beginTransaction();
		
		contacts.setUserName("18253597846");
		contacts.setContact("18253597847");
		session.save(contacts);
		tr.commit();
		session.close();
	}

}
