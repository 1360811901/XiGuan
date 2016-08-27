package com.fei.dao;

import java.util.List;

import com.fei.Entity.Focus;

public interface FocusDao {
	// 添加一个关注
	public void addFocus(Focus focus);
	// 获取所关注的人
	public List<String> getFocus(String userId);
	// 获取粉丝
	public List<String> getFans(String userId);

}
