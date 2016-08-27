package com.fei.garbage;

public class Rong {
	private int id;
	private String userName;
	private String rongToken;
	private String name;
	private String portraitUri;
	
	public Rong(){}
	
	public Rong(String user,String rongToken,String name,String portraitUri){
		this.userName = user;
		this.rongToken = rongToken;
		this.name = name;
		this.portraitUri = portraitUri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPortraitUri() {
		return portraitUri;
	}

	public void setPortraitUri(String portraitUri) {
		this.portraitUri = portraitUri;
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

	public String getRongToken() {
		return rongToken;
	}

	public void setRongToken(String rongToken) {
		this.rongToken = rongToken;
	}
	
	

}
