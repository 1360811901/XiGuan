package com.fei.garbage;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.sf.json.JSONObject;

public class Friend {
	
	private final String userFriend_map = "com/fei/dao/UserFriend.hbm.xml";
	private JSONObject js = new JSONObject();
	
	/**
	 * 获取好友信息
	 * @param userName
	 * @return
	 */
	public JSONObject getFriend(String userName){
		int number = 0;
		String[] friend = new String[0];
		SessionFactory sessionFactory = com.fei.util.Util.getSessionFactory(userFriend_map);
		Session session = sessionFactory.openSession();
		String sql = "from UserFriend where userName = " + "'" +userName + "'";
		Query query = session.createQuery(sql);
		List<UserFriend> list = query.list();
		if(list.size()==0){
			js.accumulate("number", 0);
			js.accumulate("friendNu", friend);
		}else{
			for(int i = 0;i<list.size();i++){
				friend[i]=list.get(i).getFriendName();
			}
			js.accumulate("number", list.size());
			js.accumulate("frinedNu",friend);
		}
		return js;
	}
	/**
	 * 返回好友信息的字符串形式
	 * @param userName
	 * @return
	 */
	public String toString(String userName) {
		getFriend(userName);
		return this.js.toString();
	}

}
