package com.fei.Entity;

public class Comment {
	
	private int id;
	private String dynamicId = "1";
	private String userName;
	private String cTime = "";
	private String content = "";
	
	public Comment(){}

	public Comment(int id, String dynamicId, String userName, String cTime, String content) {
		super();
		this.id = id;
		this.dynamicId = dynamicId;
		this.userName = userName;
		this.cTime = cTime;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDynamicId() {
		return dynamicId;
	}

	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	

}
