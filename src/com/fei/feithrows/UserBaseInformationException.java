package com.fei.feithrows;

public class UserBaseInformationException extends Exception{
	private static final long serialVersionUID = 4503851104626862689L;
	// 无参构造器
	public UserBaseInformationException(){}
	//带一个字符串参数的构造器
	public UserBaseInformationException(String msg){
		super(msg);
	} 
}
