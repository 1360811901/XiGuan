package com.fei.hanlder;

import java.util.List;

import com.fei.Entity.UserBaseInformation;
import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.design2.params.SaveUser_v2Params;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;

/**
 * 保存注册用户管理类
 * 1. 需要在数据库中查找用户是否已经注册 mysql 的 主键是id ,理论上还是可以再次注册上的
 *  每次注册之前还是需要再次检查数据库中是否已经有了这条记录
 * 2.因为params 是直接继承login 的，没有做任何修改，所以需要判断一下flag 的值，flag 只能是XiGuan
 * @author Administrator
 * 直接将信息保存到mysql 中
 */
public class SaveUser_v2Handler {
	
	private UserBaseInformation user = new UserBaseInformation();
	
	private void createUser(SaveUser_v2Params p){
		user.setUserName(p.getUserId());
		user.setPassWord(p.getPassWordClear());
	}
	/**
	 * 查看数据库中是否已经有用户信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<UserBaseInformation> isExist(String userId) throws Exception{
		UserBaseInformationDAOImp userInfo = new UserBaseInformationDAOImp();
		List<UserBaseInformation> users = userInfo.getUserInfo(userId);
		return users;
	}
	
	public String processSaveUser_v2(SaveUser_v2Params p) throws Exception{
		// 判断flag 的值
		if(!"XiGuan".equals(p.getFlag()))
			throw new ParamsException("private params is not valid>>>>",604); // 如果不是XiGuan ,直接抛出参数异常
		List<UserBaseInformation> users = isExist(p.getUserId());
		if(users.size() == 0){
			createUser(p); // 创建userBaseInfo 对象
			UserBaseInformationDAOImp userInfo = new UserBaseInformationDAOImp();
			userInfo.save(user);
			return "{\"code\":200,\"causeBy\":\"save user is ok >>>>\"}";
		}else if(users.size() == 1){
			return "{\"code\":801,\"causeBy\":\"user is existed >>>>\"}";
		}
		return FinalStringError.SYSTEM_ERROR;
	}
}
