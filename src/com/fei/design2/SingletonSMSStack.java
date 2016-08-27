package com.fei.design2;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 自己管理map,只返回需要的 定时清理已经过期code
 * 
 * @author Administrator
 *
 */
public class SingletonSMSStack {

	private Map<String, long[]> SMSCodeStack = new HashMap<String, long[]>();

	private static final SingletonSMSStack singletonSMSStack = new SingletonSMSStack();

	// 只能自己使用构造方法
	private SingletonSMSStack() {
		// 创建一个定时任务
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				// 循环Map 中的所有key
				for (String key : SMSCodeStack.keySet()) {
					long stampR = SMSCodeStack.get(key)[2];
					long stamp = System.currentTimeMillis();
					long difference = stamp - stampR;
					if (difference > 10800000)
						SMSCodeStack.remove(key); // 超过三个小时的code 一律无效
				}
			}
		};

		Timer timer = new Timer();
		timer.schedule(timerTask, 86400000); // 每天清除一次
	}

	// 返回单实例
	public static SingletonSMSStack getSingleton() {
		return singletonSMSStack;
	}

	// 将验证码放入 栈中
	public void putCode(String phoneNumber, long[] code) {
		SMSCodeStack.put(phoneNumber, code);
	}

	// 从栈中取出验证码
	public long[] getCode(String phoneNumber) {
		return SMSCodeStack.get(phoneNumber);
	}
	
	//从栈中 清除一个验证码
	public void removeCode(String phoneNumber){
		SMSCodeStack.remove(phoneNumber);
	}

}
