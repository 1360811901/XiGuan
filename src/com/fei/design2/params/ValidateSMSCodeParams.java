package com.fei.design2.params;

import java.util.Date;

import com.fei.design2.Params;
import com.fei.design2.Tools;

public class ValidateSMSCodeParams extends Params {
	private String code;
	private String stamp;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStamp() {
		return stamp;
	}

	public void setStamp(String stamp) {
		this.stamp = stamp;
	}

	@Override
	public boolean matchPrivateParams() {
		if(Tools.matchPhoneNumber(this.getUserId())){ //判断userId
			// 甄别code
			int size = this.code.length();
			if(size == 6){
				// 判断stamp
				try{
					long stamp = Long.parseLong(this.stamp);
					new Date(stamp); //能转换成时间就是正确的时间错
					return true;
				}catch(Exception e){
					return false;
				}
			}
				
		}
		return false;
	}

}
