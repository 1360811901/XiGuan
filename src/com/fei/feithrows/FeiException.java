package com.fei.feithrows;

public class FeiException extends Exception{
	private static final long serialVersionUID = 4900859113100245192L;
	private int CODE_ERROR;
	// 无参构造器
	public FeiException(){}
	//带一个字符串参数的构造器
	public FeiException(String msg,int code){
		super(msg);
		this.CODE_ERROR = code;
	}
	
	public int getCODE_ERROR() {
		return CODE_ERROR;
	} 
	
	@Override
	public String toString() {
		return "{\"code\":"+ this.CODE_ERROR +",\"causeBy\":\""+ this.getMessage() +"\"}";
	}
}
