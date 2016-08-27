package com.fei.hanlder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fei.Entity.UserBaseInformation;
import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.feithrows.FeiException;
import com.fei.redis.RedisC;

/**
 * 登录管理类
 * 1.验证用户名和密码
 * 2.验证成功之后保存到redis 中
 * @author Administrator
 *
 */
public class LoginHandler {
	
	private int id;
	
	/**
	 * 验证用户名和密码,之后再redis 中保存登录信息
	 * @param userId
	 * @param passWord
	 * @return
	 * @throws Exception
	 */
	public String loginProcess(String userId,String passWord) throws Exception{
		String result = "";
		UserBaseInformationDAOImp userDAO = new UserBaseInformationDAOImp();
		List<UserBaseInformation> users = userDAO.getUserInfo(userId);
		if(users.size() == 1){
			// 判断用户的密码是否正确
			String passWordM = users.get(0).getPassWord();
			id = users.get(0).getId();
			if(passWordM.equals(passWord)){
				// 用户名密码正确
				result = saveRedis(userId);
			}else{
				throw new FeiException("passWord is mistake>>>>",703);
			}
		}else{
			//用户不存在
			throw new FeiException("user is not exist>>>>",702);
		}
		
		return result;
	}
	/**
	 * 在redis 中保存登录信息
	 * @param userId
	 * @return
	 */
	public String saveRedis(String userId){
		String result = "";
		RedisC redisClient = new RedisC();
		// 保存登录状态
		com.fei.redis.Token token = com.fei.redis.Token.getTokenInstance();
		String to = token.createToken(userId);
		//String darkTo = Utils.getBase64(to);
		Map<String,String> hash = token.createHash(userId,String.valueOf(id)); // hash 集合
		Map<String,String> userIdMsg = new HashMap<String,String>();
		// 登录的次数
		int count;
		Map<String,String> a = redisClient.hashGet(userId);
		userIdMsg.put("access_token", to);
		if(a.size() == 0){
			count = 1;
		}else{
			// 不是初次登录
			count = Integer.parseInt(a.get("count"))+1;
			// 上一次登录的access_token
			String accessOld = a.get("access_token");
			// 删除上一次的access_token
			redisClient.del(accessOld);
		}
		System.out.println(count);
		userIdMsg.put("count", "" + count);
		redisClient.hashSet(to, hash); // 保存hash 集合信息
		redisClient.hashSetForEver(userId, userIdMsg); // 保存已经登录userId 信息
		result = "{\"access_token\":\"" + to + "\",\"limit\":\"604800\"}";
		return result;
	}
	
}
