package com.fei.dao;

import java.util.List;
import java.util.Map;

import com.fei.Entity.UserBaseInformation;
import com.fei.feithrows.UserBaseInformationException;

import net.sf.json.JSONObject;

public interface UserBaseInformationDAO {
	// 通过nickName 精确获取用户（昵称可以重复）
	public List<UserBaseInformation> getUserBaseInfo(String nickName) throws UserBaseInformationException;
	// 检查用户是否存在
	public boolean getUser(String userId) throws Exception;
	// 保存一个用户
	public void save(UserBaseInformation user) throws Exception;
	// 获取一个用户的信息
	public List<UserBaseInformation> getUserInfo(String userId) throws Exception;
	// 更新用户的信息
	public void update(Map<String,String> content,String userId) throws Exception;
	// 获取一个用户的信息
	public JSONObject get(String userId) throws Exception;
}
