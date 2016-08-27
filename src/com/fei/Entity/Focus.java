package com.fei.Entity;

public class Focus {
	private int id;
	private String userName;
	private String focus_userName;
	private String focus_time;

	public Focus() {
	}

	public Focus(int id, String userName, String focus_userName, String focus_time) {
		super();
		this.id = id;
		this.userName = userName;
		this.focus_userName = focus_userName;
		this.focus_time = focus_time;
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

	public String getFocus_userName() {
		return focus_userName;
	}

	public void setFocus_userName(String focus_userName) {
		this.focus_userName = focus_userName;
	}

	public String getFocus_time() {
		return focus_time;
	}

	public void setFocus_time(String focus_time) {
		this.focus_time = focus_time;
	}

}
