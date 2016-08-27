package com.fei.daoImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.UserBaseInformation;
import com.fei.dao.UserBaseInformationDAO;
import com.fei.feithrows.UserBaseInformationException;
import com.fei.tools.Utils;

import net.sf.json.JSONObject;

public class UserBaseInformationDAOImp implements UserBaseInformationDAO{
	@Override
	public List<UserBaseInformation> getUserBaseInfo(String nickName) throws UserBaseInformationException {
		List<UserBaseInformation> users = null;
		try(Session session = Utils.getSession()){
			String sql = "from UserBaseInformation where nickName = '" + nickName + "'";
			users = session.createQuery(sql).list();
		}catch(Exception e){
			e.printStackTrace();
			throw new UserBaseInformationException();
		}
		return users;
	}
	
	@Override
	public boolean getUser(String userId) throws Exception {
		boolean flag = false;
		try(Session session = Utils.getSession()){
			String sql = "from UserBaseInformation where userName = '" + userId + "'" ;
			List<UserBaseInformation> user= session.createQuery(sql).list();
			if(user.size() == 1)
				flag = true;
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
	
	@Override
	public void save(UserBaseInformation user) throws Exception {
		try(Session session = Utils.getSession()){
			Transaction tran = session.beginTransaction();
			session.save(user);
			tran.commit();
		}catch(Exception e){
			throw e;
		}
	}
	
	@Override
	public List<UserBaseInformation> getUserInfo(String userId) throws Exception {
		try(Session session = Utils.getSession()){
			String sql = "from UserBaseInformation where userName = '" + userId +"'";
			@SuppressWarnings("unchecked")
			List<UserBaseInformation> users = (List<UserBaseInformation>)session.createQuery(sql).list();
			return users;
		}catch(Exception e){
			throw e;
		}
	}
	
	@Override
	public void update(Map<String,String> content,String userId) throws Exception {
		try(Session session = Utils.getSession()){
			for(String key : content.keySet()){
				String sql = "update UserBaseInformation set "+ key +" = '" + content.get(key) + "' where userName = '" + userId + "'";
				Transaction tran = session.beginTransaction();
				session.createQuery(sql).executeUpdate();
				tran.commit();
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject get(String userId) throws Exception {
		try(Session session = Utils.getSession()){
			String sql = "from UserBaseInformation where userName ='"+ userId + "'";
			List<UserBaseInformation> users = session.createQuery(sql).list();
			JSONObject json = new JSONObject();
			if(users.size() == 1){
				UserBaseInformation user = users.get(0);
				json.accumulate("userId", user.getUserName());
				json.accumulate("nickName", user.getNickName());
				json.accumulate("sex", user.getSex());
				json.accumulate("age", user.getAge());
				json.accumulate("signature", user.getSignature());
				json.accumulate("hometown", user.getHometown());
				json.accumulate("headPortraitUrl", user.getHeadPortraitURL());
				json.accumulate("backPhotoUrl", user.getBackphotoURL());
				json.accumulate("lable", user.getLabel());
			}
			return json;
		}catch(Exception e){
			throw e;
		}
	//	return null;
	}
}
