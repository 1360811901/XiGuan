package com.fei.garbage;

import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;
import net.sf.json.JSONObject;

public class RongLogic {
	
	private final String appKey = "0vnjpoadnslfz";
	private final String appSecret = "xjQfDnnxexn8";
	private final FormatType format = FormatType.json;
	
	public String getTok(String userId,String userName,String portraitUri) throws Exception{
		String token = "";
		SdkHttpResult result = ApiHttpClient.getToken(appKey, appSecret, userId, userName, portraitUri, format);
		JSONObject js = JSONObject.fromObject(result.toString());
		if("200".equals(js.get("code"))){
			token = (String) (JSONObject.fromObject(js.get("result").toString()).get("token"));
		}else{
			token = "fail";
		}
		return token;
	}

}
