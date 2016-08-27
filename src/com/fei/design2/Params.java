package com.fei.design2;

public abstract class Params {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	// 判断私有属性的合法性
	public abstract boolean matchPrivateParams();

}
