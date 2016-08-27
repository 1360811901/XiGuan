package com.fei.logic;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.fei.sms.StringUtil;

public class FeiSendSMS {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	private int send_code = 0;
	
	public int getSend_code() {
		return send_code;
	}

	public boolean sendSMS(String phoneN){
		boolean flag = false;
		String code=null;
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url); 
				
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

		int mobile_code = (int)((Math.random()*9+1)*100000);

	    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。"); 

		NameValuePair[] data = {
			    new NameValuePair("account", "cf_jindongfei12"), 
			    new NameValuePair("password", StringUtil.MD5Encode("jindongfei01")),
			    new NameValuePair("mobile", phoneN), 
			    new NameValuePair("content", content),
		};
		
		method.setRequestBody(data);		
		
		try {
			client.executeMethod(method);	
			String SubmitResult =method.getResponseBodyAsString();
					
			Document doc = DocumentHelper.parseText(SubmitResult); 
			Element root = doc.getRootElement();


			code = root.elementText("code");	
			String msg = root.elementText("msg");	
			String smsid = root.elementText("smsid");	
						
			 if("2".equals(code)){
				 //发送验证码成功
				 send_code = mobile_code;
				 flag = true;
				System.out.println("短信提交成功");
			}
			
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}	
		return flag;
	}

}
