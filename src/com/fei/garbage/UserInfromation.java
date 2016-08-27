package com.fei.garbage;

public class UserInfromation {
	private int id;
	private String userName;
	private String name;
	private String sex;
	private Integer age;
	private String career;
	private String phoneNumber;
	private String email;
	private String address;
	private String portraitUri;
	
	public UserInfromation(){}

	public UserInfromation(String userName, String name, String sex, Integer age, String career, String phoneNumber,
			String email, String address, String portraitUri) {
		super();
		this.userName = userName;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.career = career;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPortraitUri() {
		return portraitUri;
	}

	public void setPortraitUri(String portraitUri) {
		this.portraitUri = portraitUri;
	}
	
	

}
