    package com.fei.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fei.Entity.UserBaseInformation;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

import net.sf.json.JSONArray;

public class FeiGetContacts {
	private static final String XML_MAP = "com/fei/dao/UserBaseInformation.hbm.xml";
	
	public static String getContacts(String userName){
		String result = null;
		Session session = Utils.getSession();
		String sql = "select * from user_baseinformation where username in (select contact from contactslist where username = '"+ userName +"')";
		Query query = session.createSQLQuery(sql).addEntity(UserBaseInformation.class);
		List<UserBaseInformation> users = query.list();
		if(users.size() == 0){
			result = FinalString.NOCONTACTS;
		}else{
			//只能重新处理
			JSONArray ja = new JSONArray();
			for(int i = 0;i < users.size();i++){
				UserBaseInformation user = (UserBaseInformation) users.get(i);
				System.out.println(user.getProvince());
				FeiUserInfor userInfo = new FeiUserInfor(user.getUserName(),user.getNickName(),user.getHeadPortraitURL());
				ja.add(userInfo);
			}
			result = ja.toString();
		}
		return result;
	}

}
