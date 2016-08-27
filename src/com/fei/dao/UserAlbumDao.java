package com.fei.dao;

import com.fei.Entity.UserAlbum;

import net.sf.json.JSONObject;

public interface UserAlbumDao {
	// 保存一张照片
	public void save(UserAlbum album) throws Exception;
	// 删除一张照片
	public void delete(String userInfoId,String sort) throws Exception;
	// 获取一个用户的相册信息
	public JSONObject get(String userInfoId) throws Exception;
	// 删除一张照片
	public void delete(String fileId) throws Exception;
}
