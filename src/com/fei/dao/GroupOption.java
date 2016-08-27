package com.fei.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.GroupBaseInformation;
import com.fei.tools.Utils;

public class GroupOption {
	private static final String XML_MAP = "com/fei/dao/GroupBaseInformation.hbm.xml";
	/**
	 * 保存群信息
	 * @param gi
	 */
	public static void alertRecord(GroupBaseInformation gi){
		try(Session session = Utils.getSession()){
			
			Transaction tx = session.beginTransaction();
			session.save(gi);
			session.flush();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 通过groupId 查找群
	 * @param groupId
	 * @return
	 */
	public static GroupBaseInformation findGroup(String groupId){
		GroupBaseInformation gi = null;
		try(Session session = Utils.getSession()){
			String sql = "from GroupBaseInformation where groupId = '" + groupId + "'";
			Query query = session.createQuery(sql);
			List<GroupBaseInformation> groups = query.list();
			if(groups.size() == 1)
				gi = groups.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return gi;
	}
	public static List<GroupBaseInformation> getGroup(String userName){
		List<GroupBaseInformation> gs = null;
		try(Session session = Utils.getSession()){
			String sql = "from GroupBaseInformation where groupOwn = '" + userName + "'";
			Query query = session.createQuery(sql);
			gs = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return gs;
	}
}
