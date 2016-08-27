package com.fei.Entity;

public class UserAlbum {
	private int id;
	private String url = "";
	private String userInfoId = "1";
	private String photetype = "image/jpeg";
	private String fileName = "jin.jpg";
	private String size = "0";
	private String sort = "1";
	private String isDel = "NO";

	public UserAlbum() {
	}

	public UserAlbum(int id, String url, String userInfoId, String photetype, String fileName, String size, String sort,
			String isDel) {
		super();
		this.id = id;
		this.url = url;
		this.userInfoId = userInfoId;
		this.photetype = photetype;
		this.fileName = fileName;
		this.size = size;
		this.sort = sort;
		this.isDel = isDel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getPhotetype() {
		return photetype;
	}

	public void setPhotetype(String photetype) {
		this.photetype = photetype;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	
}
