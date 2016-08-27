package com.fei.hanlder;

import com.fei.design2.Huyi;
import com.fei.design2.SingletonSMSStack;
import com.fei.design2.params.SendSMSCodeParams;

/**
 * 1.发送验证码到手机上之后，后台需要记录相应的手机号和验证码 2.同一手机号，再次发送验证码是，需要检查两次发送验证的时间差
 * 3.同一手机号，发送验证码的次数超过5之后，应该禁止再次发送
 * 
 * @author Administrator
 *
 */
public class SendSMSCodeHandler {

	private String phoneNumber;

	/**
	 * 使用互亿短信平台发送验证码
	 * 
	 * @param phoneNumber
	 * @return
	 * @throws Exception
	 */
	private int sendSMSCode() throws Exception {
		int code = Huyi.sendSMS(phoneNumber);
		return code;
	}

	/**
	 * 情况合适发送短信验证码
	 * 
	 * @param codeParams
	 * @return
	 * @throws Exception
	 */
	public String processHandler(SendSMSCodeParams codeParams) throws Exception {
		this.phoneNumber = codeParams.getUserId();
		// 1. 查找同一号码在栈中的数据
		SingletonSMSStack singletonSMS = SingletonSMSStack.getSingleton();
		long[] recode = singletonSMS.getCode(phoneNumber);
		long count = 0;
		long stamp = 0;
		long code = 0;
		if (recode == null) { // 第一次发送验证码
			code = sendSMSCode();
			stamp = System.currentTimeMillis();
		} else {
			// 判断发送验证码的次数
			count = recode[0];
			System.out.println("count: " + count);
			if (count < 5 & count > 0) {
				// 判断两次发送的时间差
				long stampC = recode[2];
				stamp = System.currentTimeMillis();
				long difference = stamp - stampC;
				System.out.println("difference: " + difference);
				if (difference > 60000) {
					code = sendSMSCode();
				} else {
					// 两次发送时间间隔太短
					return "{\"code\":902,\"causeBy\":\"send SMS is too busy >>>>\"}";
				}
			} else {
				// 发送次数已经超了
				return "{\"code\":903,\"causeBy\":\"send SMS is too many >>>>\"}";
			}

		}
		// 2.将发送的验证码保存到栈中
		long[] codeMSG = new long[] { count + 1, code, stamp };
		singletonSMS.putCode(phoneNumber, codeMSG);
		return "{\"code\":200,\"causeBy\":\"mobile code has sended >>>>\"}";
	}
}
