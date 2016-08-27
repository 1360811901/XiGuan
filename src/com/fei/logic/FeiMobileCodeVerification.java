package com.fei.logic;

import com.fei.tools.FinalString;
import com.fei.util.MySessionContext;

public class FeiMobileCodeVerification {
	private static MySessionContext myc;
	
	
	public static void setMyc(MySessionContext myc) {
		FeiMobileCodeVerification.myc = myc;
	}


	public static String verificationMobileCode(String phoneNumber,String mobileCode){
		String result = null;
		//获取服务器端保存的code
		try{
			int mobile_code = myc.getSession(phoneNumber);
			if(mobile_code == Integer.parseInt(mobileCode)){
				result = FinalString.CODE_SUC;
				// 验证完成之后删除其在jvm内存中占用的资源
				myc.DelSession(phoneNumber);
			}else{
				result = FinalString.MOBILECODE_MISTAKE;
			}
		}catch(NullPointerException e){
			// 服务器端没有找到这个号码
			result = FinalString.MOBILECODESERVER_NONE;
		}
		return result;
		
	}
}
