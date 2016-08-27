package com.fei.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.ContactsList;
import com.fei.dao.ContactsListDAO;
import com.fei.tools.Utils;

public class ContactsListDAOImp implements ContactsListDAO{
	private static final String XML_MAP = "com/fei/dao/ContactsList.hbm.xml";
	
	@Override
	public void deleteContact(String userName, String contact) {
		try(Session session = Utils.getSession()){
			Transaction tx = session.beginTransaction();
			String sql =  "delete ContactsList where userName = '" + userName + "' and contact = '" + contact + "'" ;
			session.delete(sql);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@Override
	public int findContact(String userName, String contact) {
		int i = 0;
		try(Session session = Utils.getSession()){
			String sql = "from ContactsList where userName = '" + userName + "' and contact = '" + contact + "'" ;
			Query query = session.createQuery(sql);
			List<ContactsList> contacts = query.list();
			i = contacts.size();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return i;
	}
}
