package com.fei.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.Focus;
import com.fei.dao.FocusDao;
import com.fei.tools.Utils;

public class FocusDaoImp implements FocusDao {

	@Override
	public void addFocus(Focus focus) {
		
		try(Session session = Utils.getSession()){
			Transaction tran = session.beginTransaction();
			session.save(focus);
			tran.commit();
		}

	}

	@Override
	public List<String> getFocus(String userId) {
		
		try(Session session = Utils.getSession()){
			String sql = "from Focus where userName = '" + userId + "'";
			
		}
		
		return null;
	}

	@Override
	public List<String> getFans(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
