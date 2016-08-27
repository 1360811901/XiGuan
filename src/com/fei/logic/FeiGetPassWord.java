package com.fei.logic;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fei.Entity.UserBaseInformation;
import com.fei.tools.FinalString;

public class FeiGetPassWord {
	
	private static Logger logger = Logger.getLogger(FeiGetPassWord.class);    
	private static final String XML_MAP = "com/fei/dao/UserBaseInformation.hbm.xml";
	private static String result = null;
	
	
	public static String getResult() {
		return result;
	}


	public static String getPassWrod(String userName){
		String passWord = null;
		Session session = com.fei.tools.Utils.getSession();
		String sql = " from UserBaseInformation where userName = " + "'" + userName + "'";
		Query query = session.createQuery(sql);
		List<UserBaseInformation> user = query.list();
		if(user.size() == 0){
			result = FinalString.USER_NOEXIT;
		}else if(user.size() == 1){
			passWord = user.get(0).getPassWord();
		}else{
			//出现 用户名重复的情况，输出相应的日志
			result = FinalString.SYSTEM_ERROR; 
			logger.warn("have repeat userName");
		}
		//关闭session
		session.close();
		return passWord;
	}

}
