package com.fei.Entity;

public class UserDynamics {
	private int id;
	private String userName;
	private String dnId;
	private String content = "";
	private String uTime = "";
	private String longitude = "121.456581";
	private String latitude = "37.494037";
	private String province = "山东";
	private String city = "烟台";
	private String clickOnLike = "0";
	private String commentNumber = "0";
	private String uType = "persional";
	private String destination = "烟台";
	private String beginTime = "201607201420";
	private String overTime = "201607201820";
	
	public UserDynamics(){}

	public UserDynamics(int id, String userName, String dnId, String content, String uTime, String longitude,
			String latitude, String province, String city, String clickOnLike, String commentNumber, String uType,
			String destination, String beginTime, String overTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.dnId = dnId;
		this.content = content;
		this.uTime = uTime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.province = province;
		this.city = city;
		this.clickOnLike = clickOnLike;
		this.commentNumber = commentNumber;
		this.uType = uType;
		this.destination = destination;
		this.beginTime = beginTime;
		this.overTime = overTime;
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

	public String getDnId() {
		return dnId;
	}

	public void setDnId(String dnId) {
		this.dnId = dnId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getuTime() {
		return uTime;
	}

	public void setuTime(String uTime) {
		this.uTime = uTime;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClickOnLike() {
		return clickOnLike;
	}

	public void setClickOnLike(String clickOnLike) {
		this.clickOnLike = clickOnLike;
	}

	public String getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(String commentNumber) {
		this.commentNumber = commentNumber;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	
	
	
	

}
