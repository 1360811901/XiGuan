package com.fei.sms;

public class SMS {
	private PhoneNumber p;
	private String content;
	private String letterWriter;
	public SMS(PhoneNumber p, String content, String letterWriter) {
		super();
		this.p = p;
		this.content = content;
		this.letterWriter = letterWriter;
	}
	public PhoneNumber getP() {
		return p;
	}
	public void setP(PhoneNumber p) {
		this.p = p;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLetterWriter() {
		return letterWriter;
	}
	public void setLetterWriter(String letterWriter) {
		this.letterWriter = letterWriter;
	}
	
	
	

}
