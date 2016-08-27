package com.fei.design2.params;

public enum ThirdParty {

	XIGUAN("XiGuan"), WEIXIN("weixin"), WEIBO("weibo");

	private final String name;

	private ThirdParty(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
