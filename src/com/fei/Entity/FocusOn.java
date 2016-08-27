package com.fei.Entity;

public class FocusOn {
	
	private int id;
	private String userName;
	private String focusOn_userName;
	private String fTime = "";
	private String focusOnNumber = "0";
	private String fansNumber = "0";
	
	public FocusOn(){}

	public FocusOn(int id, String userName, String focusOn_userName, String fTime, String focusOnNumber,
			String fansNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.focusOn_userName = focusOn_userName;
		this.fTime = fTime;
		this.focusOnNumber = focusOnNumber;
		this.fansNumber = fansNumber;
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

	public String getFocusOn_userName() {
		return focusOn_userName;
	}

	public void setFocusOn_userName(String focusOn_userName) {
		this.focusOn_userName = focusOn_userName;
	}

	public String getfTime() {
		return fTime;
	}

	public void setfTime(String fTime) {
		this.fTime = fTime;
	}

	public String getFocusOnNumber() {
		return focusOnNumber;
	}

	public void setFocusOnNumber(String focusOnNumber) {
		this.focusOnNumber = focusOnNumber;
	}

	public String getFansNumber() {
		return fansNumber;
	}

	public void setFansNumber(String fansNumber) {
		this.fansNumber = fansNumber;
	}

	
	
	

}
