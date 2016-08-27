package com.fei.hanlder;

import com.fei.daoImpl.UserAlbumDaoImp;
import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.design2.Params;
import com.fei.design2.params.GetUserBaseInfoParams;
import com.fei.feithrows.FinalStringError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 获取用户的基本信息
 * @author Administrator
 *
 */
public class GetUserBaseInfoHandler extends Handler {

	@Override
	public String processHandler(Params p) {
		GetUserBaseInfoParams params = (GetUserBaseInfoParams)p;
		String userId = params.getUserId();
		try{
			// 获取相册信息
			UserAlbumDaoImp userAlbum = new UserAlbumDaoImp();
			JSONObject json = userAlbum.get(userId);
			
			// 获取用户的基本信息
			UserBaseInformationDAOImp userDao = new UserBaseInformationDAOImp();
			JSONObject js = userDao.get(userId);
			
			// 将两个信息合并成一个jsonArray
			JSONArray jsonArray = new JSONArray();
			jsonArray.add(json);
			jsonArray.add(js);
			return jsonArray.toString();
		}catch(Exception e){
			return FinalStringError.SYSTEM_ERROR;
		}
		//return null;
	}

}
