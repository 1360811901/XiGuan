package com.fei.logic;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.ContactsList;
import com.fei.daoImpl.ContactsListDAOImp;
import com.fei.tools.Utils;

public class FeiAddContacts {
	private static final String XML_MAP = "com/fei/dao/ContactsList.hbm.xml";
	
	public static boolean addContact(String userName,String contact){
		boolean flag = false;
		Session session = Utils.getSession();
		// 检查两人是否已经是好友
		ContactsListDAOImp con = new ContactsListDAOImp();
		int i = con.findContact(userName, contact);
		if(i == 0){
			Transaction tr = session.beginTransaction();
			ContactsList contacts = new ContactsList();
			try{
				contacts.setUserName(userName);
				contacts.setContact(contact);
				session.save(contacts);
				tr.commit();
				session.close();
				flag = true;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return flag;
	}
}
