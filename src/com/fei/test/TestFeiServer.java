package com.fei.test;

import com.fei.tools.Utils;

public class TestFeiServer {
	public static void main(String[] args) throws Exception{
		// 对加盐之后的密码进行base64编码和解码
		String s = Utils.getBase64("jindongfei$a123456");
		System.out.println(s);
		String s2 = Utils.getFromBase64(s);
		System.out.println(s2);
		System.out.println(System.currentTimeMillis());
		//HttpRequest.sendPostRequest("/login/userLogin2", "userId=18253597846&password=jindongfei$a123456");
		//HttpRequest.sendPostRequest("/TestServlet2", "userId=18253597846&password=jindongfei$a123456");
		//HttpRuquest.setPostRequest("http://localhost:8088/feiServer/TestServlet2", "userId=18253597846&password=jindongfei$a123456");
		//HttpRequest.sendPostRequest("/login/userLogin", "userId=1825359784j&passWord=amluZG9uZ2ZlaSRhMTIzNDU2");
		//HttpRequest.sendPostRequest("/v2/login/resetPassWord", "userId=18253597846&passWord=amluZG9uZ2ZlaSRhMTIzNDU2&flag=XiGuan");
		//HttpRequest.sendPostRequest("/v2/login/sendSMSCode", "userId=18253597846&stamp=1471575552897");
		//HttpRequest.sendPostRequest("/v2/login/login", "userId=18253597846&passWord=amluZG9uZ2ZlaSRhMTIzNDU2&flag=XiGuan");
		//HttpRequest.sendPostRequest("/chitchat/getFriendsList", "userId=18253597846&access_token=18253597846J14718361379031");
		HttpRequest.sendPostRequest("/v2/user/getUserBaseInfo", "userId=18253597846&access_token=18253597846J14719167409941"); 
		//HttpRequest.sendPostRequest("/v2/user/deleteAlbum", "userId=18253597846&access_token=18253597846J14719167409941&fileId=18253597846j1472203224039419.png"); 
	}

}
