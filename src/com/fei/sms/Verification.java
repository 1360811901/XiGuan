package com.fei.sms;

public interface Verification {
	/**
	 * 两个值得验证比较
	 * @param arg1
	 * @param arg2
	 * @return 返回是否正确
	 */
	public abstract boolean verication(Object arg1,Object arg2);
	/**
	 * 处理验证的结果
	 * @param s代表结果的状态
	 */
	public abstract void handleResult(String s);
}
