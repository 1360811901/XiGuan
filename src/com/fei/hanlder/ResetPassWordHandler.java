package com.fei.hanlder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fei.Entity.UserBaseInformation;
import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.design2.params.SaveUser_v2Params;
import com.fei.feithrows.ParamsException;

/**
 * 重置密码 直接使用SaveUser_v2Params 修改密码之前，首先的确认这个账号时存在的
 * 
 * @author Administrator
 *
 */
public class ResetPassWordHandler {
	private Map<String, String> content = new HashMap<String, String>();
	private UserBaseInformationDAOImp userDao = new UserBaseInformationDAOImp();

	private boolean isExist(String userId) throws Exception {
		List<UserBaseInformation> users = userDao.getUserInfo(userId);
		if (users.size() == 1)
			return true;
		return false;
	}

	private void createContent(SaveUser_v2Params params) {
		content.put("passWord", params.getPassWordClear());
	}

	public String processHandler(SaveUser_v2Params params) throws ParamsException {
		// 使用loginParams 必须判断flag 的值
		if(!"XiGuan".equals(params.getFlag()))
			throw new ParamsException("private params is not valid>>>>",604); // 如果不是XiGuan ,直接抛出参数异常
		
		try {
			if (isExist(params.getUserId())) {
				createContent(params);
				userDao.update(content, params.getUserId());
				return "{\"code\":200,\"causeBy\":\"change passWord is ok >>>> \"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"code\":702,\"causeBy\":\"user is not exist>>>>\"}";
	}
}
 