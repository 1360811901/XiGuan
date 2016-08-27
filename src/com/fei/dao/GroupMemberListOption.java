package com.fei.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.GroupMemberList;
import com.fei.tools.Utils;

public class GroupMemberListOption {
	private static final String XML_MAP = "com/fei/dao/GroupMemberList.hbm.xml";
	
	/**
	 * 保存一条记录
	 * @param userName
	 * @param groupId
	 */
	public static void insertList(String userName,String groupId){
		GroupMemberList gl = new GroupMemberList();
		gl.setUserName(userName);
		gl.setGroupId(groupId);
		try(Session session = Utils.getSession()){
			Transaction tx = session.beginTransaction();
			session.save(gl);
			tx.commit();
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 查找一条记录
	 * @param userName
	 * @param groupId
	 * @return
	 */
	public static GroupMemberList findList(String userName,String groupId){
		GroupMemberList gl = null;
		try(Session session = Utils.getSession()){
			String sql = "from GroupMemberList where userName = '" + userName + "' and groupId = '" + groupId + "'" ;
			Query query = session.createQuery(sql);
			List<GroupMemberList> lists = query.list();
			if(lists.size() >= 1)
				gl = lists.get(0);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return gl;
	}
	/**
	 * 删除一条记录
	 * @param userName
	 * @param groupId
	 */
	public static void deleteList(String userName,String groupId){
		try(Session session = Utils.getSession()){
			String sql = "delete GroupMemberList where userName = '" + userName + "' and groupId = '" + groupId + "'" ;
			Transaction tx = session.beginTransaction();
			session.delete(sql);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
