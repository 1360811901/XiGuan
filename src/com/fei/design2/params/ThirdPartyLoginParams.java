package com.fei.design2.params;

import com.fei.design2.Params;

public class ThirdPartyLoginParams extends Params {

	private String headPortraitUrl;
	private String nickName;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getHeadPortraitUrl() {
		return headPortraitUrl;
	}

	public void setHeadPortraitUrl(String headPortraitUrl) {
		this.headPortraitUrl = headPortraitUrl;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	/**
	 * 昵称不能为空 headPortraitUrl 不能为空
	 */
	public boolean matchPrivateParams() {
		if ("".equals(this.nickName) | this.nickName == null)
			return false;
		if ("".equals(this.headPortraitUrl) | this.headPortraitUrl == null)
			return false;
		if(!("weixin".equals(this.flag)|"weibo".equals(this.flag)))
			return false;
		return true;
	}

}
