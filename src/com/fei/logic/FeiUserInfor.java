package com.fei.logic;

public class FeiUserInfor {

	private String userName;
	private String nickName;
	private String headPortraitURL;
	
	public FeiUserInfor(){}

	public FeiUserInfor(String userName, String nickName, String headPortraitURL) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.headPortraitURL = headPortraitURL;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPortraitURL() {
		return headPortraitURL;
	}

	public void setHeadPortraitURL(String headPortraitURL) {
		this.headPortraitURL = headPortraitURL;
	}
	
	
}
