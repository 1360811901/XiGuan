package com.fei.hanlder;

import java.util.List;

import com.fei.Entity.UserBaseInformation;
import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.design2.params.ThirdPartyLoginParams;
import com.fei.feithrows.FinalStringError;

/**
 * 1.将第三方信息保存到数据库中 2.防止重复保存 3.保存时将密码设置成默认的"s666666"
 * 
 * @author Administrator
 *
 */
public class ThirdPartyLoginHandler {
	private UserBaseInformation thirdUser = new UserBaseInformation();

	/**
	 * 查看数据库中是否已有相应信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<UserBaseInformation> isExist(String userId) throws Exception {
		UserBaseInformationDAOImp userDao = new UserBaseInformationDAOImp();
		List<UserBaseInformation> users = userDao.getUserInfo(userId);
		return users;
	}

	/**
	 * 创建user 对象
	 * 
	 * @param thirdParams
	 */
	private void createUserInfo(ThirdPartyLoginParams thirdParams) {
		thirdUser.setHeadPortraitURL(thirdParams.getHeadPortraitUrl());
		thirdUser.setUserName(thirdParams.getUserId());
		thirdUser.setNickName(thirdParams.getNickName());
		thirdUser.setPassWord("s666666"); // 第三方的默认登陆密码
		if ("weixin".equals(thirdParams.getFlag())) {
			thirdUser.setIsWeiXin("YES");
		} else {
			thirdUser.setIsSina("YES");
		}

	}
	/**
	 * process Handler
	 * @param thirdParams
	 * @return
	 * @throws Exception
	 */
	public String processHandler(ThirdPartyLoginParams thirdParams) throws Exception {
		List<UserBaseInformation> users = isExist(thirdParams.getUserId());
		if (users.size() == 0) {
			createUserInfo(thirdParams);
			UserBaseInformationDAOImp userDao = new UserBaseInformationDAOImp();
			userDao.save(thirdUser); // 保存到mysql 中
			return "{\"code\":200,\"causeBy\":\"save user is ok >>>>\"}";
		} else if (users.size() == 1) {
			return "{\"code\":801,\"causeBy\":\"user is existed >>>>\"}";
		}
		return FinalStringError.SYSTEM_ERROR;
	}
}
