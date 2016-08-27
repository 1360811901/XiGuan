package com.fei.design2;

public class ParamsString {

	private String needParams;

	public void setNeedParams(String needParams) {
		this.needParams = needParams;
	}

	public String[] getNeedKeys() {
		return needParams.split("@");
	}

}
