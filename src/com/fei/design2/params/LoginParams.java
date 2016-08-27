package com.fei.design2.params;

import java.io.IOException;
import java.util.regex.Pattern;

import com.fei.design2.Params;
import com.fei.design2.Tools;
import com.fei.tools.Utils;

public class LoginParams extends Params {
	private String passWord;
	private String flag;
	private String passWordClear;
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public boolean matchPrivateParams() {
		// 1. 将密码翻译出来
		String salt = "";
		String passWordC = "";
		try {
			//获取盐值
			salt = Utils.getFromBase64(this.passWord).substring(0, 11);
			//数组下标是从零开始
			passWordC = Utils.getFromBase64(this.passWord).substring(11);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 验证密码格式
		String pattern2 = "^[a-zA-Z]\\w{5,8}$";
		boolean a = Pattern.matches(pattern2, passWordC);
		boolean b = "jindongfei$".equals(salt);
		if(a&b){
			this.passWordClear = passWordC;
			if("XiGuan".equals(this.flag)){
				//验证userId
				boolean match = Tools.matchPhoneNumber(this.getUserId());
				if(match)
					return true;
			}else if("weixin".equals(this.flag)){
				// 是微信账号
				return true;
			}else if("weibo".equals(this.flag)){
				// 是微博账号
				return true;
			}
		}
		return false;
	}

	public String getPassWordClear() {
		return passWordClear;
	}

	public void setPassWordClear(String passWordClear) {
		this.passWordClear = passWordClear;
	}
}
