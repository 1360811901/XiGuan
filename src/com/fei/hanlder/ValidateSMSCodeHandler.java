package com.fei.hanlder;

import com.fei.design2.SingletonSMSStack;
import com.fei.design2.params.ValidateSMSCodeParams;

/**
 * 验证短信验证码 1. 短信验证码的有效时间设置3 个小时，超过三个小时，这个验证码就禁止使用 2. 验证码验证完成之后，需要从栈中去除此验证码 3.
 * 需要一个定时任务，清除栈中已经无效的验证码，code栈中已经实现 4. 确认这个号码是发送过验证码的
 * 
 * @author Administrator
 *
 */
public class ValidateSMSCodeHandler {
	private String phoneNumber;

	public String processHandler(ValidateSMSCodeParams params) {
		this.phoneNumber = params.getUserId();

		// 从栈中取出codeMsg
		SingletonSMSStack singletonSMS = SingletonSMSStack.getSingleton();
		long[] codeMsg = singletonSMS.getCode(phoneNumber);

		if (codeMsg != null) {
			long code = codeMsg[1];
			long stamp = codeMsg[2];

			// 确认验证码没有超时
			long difference = System.currentTimeMillis() - stamp;
			if (difference < 10800000) {
				// 验证验证码是否正确
				if (code == Long.parseLong(params.getCode()))
					return "{\"code\":200,\"causeBy\":\"mobile code is correct >>>>\"}";
				return "{\"code\":1001,\"causeBy\":\"mobile code is error >>>>\"}";
			} else {
				// 超时的验证码
				return "{\"code\":1002,\"causeBy\":\"mobile code is overtime >>>>\"}";
			}
		}

		return "{\"code\":1003,\"causeBy\":\"phoneNumber has not send SMS >>>>\"}";
	}
}
