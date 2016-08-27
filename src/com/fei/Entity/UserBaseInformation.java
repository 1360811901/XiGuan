package com.fei.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed(index="userBaseInfo")
public class UserBaseInformation {
	// mysql 中的默认值在bean 中的体现是应该初始化，否者建表语句的默认值无意思
	@Id
	@GeneratedValue
	private int id;
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String userName;
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String passWord;
	
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.YES)
	private String nickName = "";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String sex = "girl";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String age = "18";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String career = "";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String email = "";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String headPortraitURL = "";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String longitude = "121.456581";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String latitude = "37.494037";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String province = "山东省";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String city = "烟台市";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String rongToken = "";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String vip = "0";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String isWeiXin = "no";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String isSina = "no";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String signature = "好好学习，报效祖国";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String backphotoURL = "/default/img/back.jpg";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String education = "本科";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String hometown = "山东烟台";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String constellation = "兔子";
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String label = "闲的";
	
	public UserBaseInformation(){}

	public UserBaseInformation(int id, String userName, String passWord, String nickName, String sex, String age,
			String career, String email, String headPortraitURL, String longitude, String latitude, String province,
			String city, String rongToken, String vip, String isWeiXin, String isSina, String signature,
			String backphotoURL, String education, String hometown, String constellation, String label) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.career = career;
		this.email = email;
		this.headPortraitURL = headPortraitURL;
		this.longitude = longitude;
		this.latitude = latitude;
		this.province = province;
		this.city = city;
		this.rongToken = rongToken;
		this.vip = vip;
		this.isWeiXin = isWeiXin;
		this.isSina = isSina;
		this.signature = signature;
		this.backphotoURL = backphotoURL;
		this.education = education;
		this.hometown = hometown;
		this.constellation = constellation;
		this.label = label;
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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadPortraitURL() {
		return headPortraitURL;
	}

	public void setHeadPortraitURL(String headPortraitURL) {
		this.headPortraitURL = headPortraitURL;
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

	public String getRongToken() {
		return rongToken;
	}

	public void setRongToken(String rongToken) {
		this.rongToken = rongToken;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getIsWeiXin() {
		return isWeiXin;
	}

	public void setIsWeiXin(String isWeiXin) {
		this.isWeiXin = isWeiXin;
	}

	public String getIsSina() {
		return isSina;
	}

	public void setIsSina(String isSina) {
		this.isSina = isSina;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getBackphotoURL() {
		return backphotoURL;
	}

	public void setBackphotoURL(String backphotoURL) {
		this.backphotoURL = backphotoURL;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
	
	

}
