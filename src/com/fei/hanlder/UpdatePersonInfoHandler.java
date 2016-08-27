package com.fei.hanlder;

import java.util.HashMap;
import java.util.Map;

import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.design2.Params;
import com.fei.design2.params.UpdatePersonInfoParams;
import com.fei.feithrows.FinalStringError;

/**
 * 更新个人资料
 * @author Administrator
 *
 */
public class UpdatePersonInfoHandler extends Handler {

	
	public String processHandler(Params p) {
		UserBaseInformationDAOImp userDao = new UserBaseInformationDAOImp();
		UpdatePersonInfoParams userInfo = (UpdatePersonInfoParams) p;
		
		Map<String,String> msg = new HashMap<String,String>();
		msg.put(userInfo.getFieldKey(), userInfo.getFieldValue());
		try {
			userDao.update(msg, userInfo.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			return FinalStringError.SYSTEM_ERROR;
		}
		return "{\"code\":200,\"causeBy\":\"update personal information is success >>>>\"}";
	}

}
