package com.fei.design2.params;

import com.fei.design2.Params;

public class UpdatePersonImgParams extends Params {
	private String flag;
	private String imgUrl;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public boolean matchPrivateParams() {
		boolean f = false;
		switch (this.flag) {
		case "headPortraitURL":
			f = true;
			break;
		case "backphotoURL":
			f = true;
			break;
		}
		return f;
	}

}
