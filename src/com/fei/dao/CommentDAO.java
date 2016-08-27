package com.fei.dao;

import com.fei.Entity.Comment;

public interface CommentDAO {
	//保存信息
	public void save(Comment comment) throws Exception;
}
