package com.fei.dao;

public interface ContactsListDAO {
	public void deleteContact(String userName,String contact); //删除联系人
	public int findContact(String userName,String contact);// 查找联系人
}
