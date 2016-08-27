package com.fei.Entity;

public class DynamicPhoto {
	private int id;
	private String url = "";
	private String dynamicId = "1";
	private String photeType = "image/jpeg";
	private String fileName = "jin.jpg";
	private String size = "0";
	
	public DynamicPhoto(){}

	public DynamicPhoto(int id, String url, String dynamicId, String photeType, String fileName, String size) {
		super();
		this.id = id;
		this.url = url;
		this.dynamicId = dynamicId;
		this.photeType = photeType;
		this.fileName = fileName;
		this.size = size;
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

	public String getDynamicId() {
		return dynamicId;
	}

	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
	}

	public String getPhoteType() {
		return photeType;
	}

	public void setPhoteType(String photeType) {
		this.photeType = photeType;
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

	
	
	
}
