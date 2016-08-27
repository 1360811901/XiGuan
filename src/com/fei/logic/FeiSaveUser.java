package com.fei.logic;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.UserBaseInformation;
import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

import net.sf.json.JSONObject;

public class FeiSaveUser {
	
	private static final String XML_MAP = "com/fei/dao/UserBaseInformation.hbm.xml";
	
	public static String saveUser(String userName,String passWord) throws Exception{
		String saveResult = null;
		//检查用户是否存在
		UserBaseInformationDAOImp userb = new UserBaseInformationDAOImp();
		boolean result = userb.getUser(userName);
		//返回603 表示用户不存在
		if(result){
			Session session = Utils.getSession();
			UserBaseInformation user = new UserBaseInformation();
			user.setUserName(userName);
			user.setPassWord(passWord);
			user.setNickName(userName);
			Transaction tr = session.beginTransaction();
			session.save(user);
			tr.commit();
			session.close();
			saveResult = FinalString.CODE_SUC;
		}else{
			saveResult = FinalString.SAVEUSER_ERROR;
		}
		return saveResult;
	}

}
