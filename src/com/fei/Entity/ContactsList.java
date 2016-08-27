package com.fei.Entity;

public class ContactsList {
	
	private int id;
	private String userName;
	private String contact;
	private String classify = "我的好友";
	
	public ContactsList(){}

	public ContactsList(int id, String userName, String contact, String classify) {
		super();
		this.id = id;
		this.userName = userName;
		this.contact = contact;
		this.classify = classify;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	

}
