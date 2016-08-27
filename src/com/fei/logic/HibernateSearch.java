package com.fei.logic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.fei.Entity.UserBaseInformation;
import com.fei.tools.HibernateUtil;
import com.fei.tools.Utils;

public class HibernateSearch {
	
	private static Session session1 = HibernateUtil.currentSession();
	
	//search
	public static String search(String s) throws InterruptedException{
		// 建立索引
		Session session = Utils.getSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		fullTextSession.createIndexer().startAndWait();
		//search
		Transaction tx = fullTextSession.beginTransaction();
		QueryBuilder qb = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(UserBaseInformation.class).get();
		org.apache.lucene.search.Query query = qb
				.keyword()
				.onFields("nickName")
				.matching(s)
				.createQuery();
		// wrap Lucene query in a org.hibernate.Query
		Query hibQuery =
		fullTextSession.createFullTextQuery(query, UserBaseInformation.class);
		// execute search
		List<UserBaseInformation> users = hibQuery.list();
		tx.commit();
		session.close();
		String results = Utils.getInstanceInfo(users);
		return results;
	}
}
