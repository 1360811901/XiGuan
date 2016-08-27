package com.fei.dao;

import java.util.Map;

public interface UserDynamicsDAO {
	// 保存信息
	public void save(Map<String,String> formFields,String dnId) throws Exception;
	
	// 点赞
	public void clickOnLike(String dnid) throws Exception;
	
}
