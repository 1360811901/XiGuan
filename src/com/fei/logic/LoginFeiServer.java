package com.fei.logic;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fei.Entity.UserBaseInformation;
import com.fei.redis.RedisC;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

public class LoginFeiServer {
	
	private static Logger logger = Logger.getLogger(LoginFeiServer.class);    
	private static final String XML_MAP = "com/fei/dao/UserBaseInformation.hbm.xml";
	
	public static String loginFei(String userName,String passWord) throws UnsupportedEncodingException{
		String result = null;
		Session session = com.fei.tools.Utils.getSession();
		String sql = " from UserBaseInformation where userName = " + "'" + userName + "'";
		Query query = session.createQuery(sql);
		List<UserBaseInformation> user = query.list();
		if(user.size() == 0){
			result = FinalString.USER_NOEXIT;
		}else if(user.size() == 1){
			String passMysql = user.get(0).getPassWord();
			int id = user.get(0).getId();
			if(passMysql.equals(passWord)){
				RedisC redis = new RedisC();
				// 判断用户是否已经登录
				if("1".equals(redis.StringGet(userName))){
					// 用户已经登录
					result = "{\"code\":\"600\",\"causeby\":\"user has login,please not repeat>>>\"}";
				}else{
					// 保存登录状态
					com.fei.redis.Token token = com.fei.redis.Token.getTokenInstance();
					String to = token.createToken(userName);
					//String darkTo = Utils.getBase64(to);
					Map<String,String> hash = token.createHash(userName,String.valueOf(id));
					redis.hashSet(to, hash);
					redis.StringSet(userName);
					result = "{\"access_token\":\"" + to + "\",\"limit\":\"604800\"}";
				}
			}else{
				result = FinalString.PASSWORD_ERROR;
			}
		}else{
			//出现 用户名重复的情况，输出相应的日志
			result = FinalString.SYSTEM_ERROR; 
			logger.warn("have repeat userName");
		}
		//关闭session
		session.close();
		return result;
	}

}
