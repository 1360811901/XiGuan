package com.fei.design2;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.fei.feithrows.FeiException;
import com.fei.sms.StringUtil;

/**
 * 互亿短信平台
 * 
 * @author Administrator
 *
 */
public class Huyi {

	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	private static final String userId = "cf_jindongfei12";
	private static final String passWord = StringUtil.MD5Encode("jindongfei01");

	public static int sendSMS(String phoneNumber) throws Exception {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

		String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

		NameValuePair[] data = { new NameValuePair("account", userId), new NameValuePair("password", passWord),
				new NameValuePair("mobile", phoneNumber), new NameValuePair("content", content), };

		method.setRequestBody(data);

		client.executeMethod(method);
		String SubmitResult = method.getResponseBodyAsString();

		Document doc = DocumentHelper.parseText(SubmitResult);
		Element root = doc.getRootElement();

		String code = root.elementText("code");
		String msg = root.elementText("msg");
		String smsid = root.elementText("smsid");

		if ("2".equals(code)) {
			// 发送验证码成功
			System.out.println("短信提交成功");
			return mobile_code;
		} else {
			System.out.println(msg);
			System.out.println(smsid);
			throw new FeiException("huyi send sms is error>>>>", 901);
		}

	}

}
