package com.fei.sms;
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

public class sendsms {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	
	
	
	public static void main(String [] args) {
		
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url); 
			
		//client.getParams().setContentCharset("GBK");		
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

		
		int mobile_code = (int)((Math.random()*9+1)*100000);

		//System.out.println(mobile);
		
	    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。"); 

		NameValuePair[] data = {
			    new NameValuePair("account", "cf_jindongfei12"), 
			    //new NameValuePair("password", "jindongfei01"), 
			    new NameValuePair("password", StringUtil.MD5Encode("jindongfei01")),
			    new NameValuePair("mobile", "18253597846"), 
			    new NameValuePair("content", content),
		};
		
		method.setRequestBody(data);		
		
		
		try {
			client.executeMethod(method);	
			
			String SubmitResult =method.getResponseBodyAsString();
					
			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult); 
			Element root = doc.getRootElement();


			String code = root.elementText("code");	
			String msg = root.elementText("msg");	
			String smsid = root.elementText("smsid");	
			
			
			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);
			System.out.println(mobile_code);
			System.out.println(StringUtil.MD5Encode("jindongfei01"));
			System.out.println(SubmitResult);
						
			 if("2".equals(code)){
				System.out.println("短信提交成功");
			}
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}