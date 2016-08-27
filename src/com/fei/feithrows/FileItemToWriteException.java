package com.fei.feithrows;

public class FileItemToWriteException extends Exception {

	private static final long serialVersionUID = 374269935125167348L;
	// 无参构造器
	public FileItemToWriteException(){}
	//带一个字符串参数的构造器
	public FileItemToWriteException(String msg){
		super(msg);
	} 
}
