package com.fei.design2;

import java.util.Map;


import com.fei.feithrows.ParamsException;
import com.fei.fileUpload.FileUp;
import com.fei.redis.RedisC;
import com.fei.tools.FinalString;


public class FileUploadFactory {
	
	@SuppressWarnings("unchecked")
	public <T extends Params> T createFileParams(Class<T> c,FileUp fileUpload,ParamsString ps) throws Exception{
		// 定义一个Params
		Params params = null;
		try{
			//params = (T)Class.forName(c.getName()).newInstance();
			Map<String,String> formField = fileUpload.getFormField();
			//List<FileItem> fileItems = fileUpload.getFileItems();
			
			// 1. 验证keys
			SingletonTools singletonTools = SingletonTools.getSingleInstance();
			boolean ba = singletonTools.matchKeys(ps,formField.keySet());
			if(!ba)
				throw new ParamsException("params key is not correct>>>>",601);
			String access_token = formField.get("access_token"); // 获取access_token
			RedisC redisc = new RedisC();
			// 判断access_token 在redis 中是否存在
			boolean bb = redisc.exitToken(access_token);
			if (!bb)
				throw new ParamsException("params access_token is not valid , please login in>>>>",602);
			// 判断userId 和 redis 中保存的是否相等
			Map<String, String> hash = redisc.hashGet(access_token);
			String userId_hash = hash.get(FinalString.USERNAME);
			String userId = formField.get(FinalString.USERNAME);
			boolean bc = userId_hash.equals(userId);
			if (!bc)
				throw new ParamsException("userId is error>>>>",603);
			
			// 组装params
			params = Tools.mapToBean(c, formField);
			boolean bd = params.matchPrivateParams();
			if (!bd)
				throw new ParamsException("private params is not valid>>>>",604);
		}catch(Exception e){
			throw e;
		}
		return (T)params;
	}
}
