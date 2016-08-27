package com.fei.dao;

import java.util.Map;

public interface DynamicPhotoDAO {
	//保存信息
	public void save(Map<String,String> photoInfo) throws Exception;
}
