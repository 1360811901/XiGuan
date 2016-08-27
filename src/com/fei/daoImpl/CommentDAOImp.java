package com.fei.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.Comment;
import com.fei.dao.CommentDAO;
import com.fei.tools.Utils;

public class CommentDAOImp implements CommentDAO{

	@Override
	public void save(Comment comment) throws Exception {
		try(Session session = Utils.getSession()){
			Transaction tx = session.beginTransaction();
			session.save(comment);
			tx.commit();
		}catch(Exception e){
			throw e;
		}
	}
}
