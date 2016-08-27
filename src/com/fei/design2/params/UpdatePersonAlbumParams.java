package com.fei.design2.params;

import com.fei.design2.Params;

public class UpdatePersonAlbumParams extends Params {
	private String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public boolean matchPrivateParams() {
		boolean s = false;
		switch(this.flag){
		case "album":s = true;
		}
		return s;
	}

}
