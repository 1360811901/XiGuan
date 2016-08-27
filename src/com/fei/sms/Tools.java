package com.fei.sms;

import java.util.Random;
import java.util.regex.Pattern;

public class Tools {
	private static final String REG_PHONE = "^[1][358][0-9]{9}$";
	
	/**
	 * ��֤�绰�������Ч��
	 * @param s
	 * @return
	 * o method is problem
	 * 1 string is error format
	 * ....... is true
	 */
	public static int verificationPhoneN(String s){
		int ph = 0;
		boolean b = Pattern.matches(REG_PHONE, s);
		if(b){
			ph = Integer.parseInt(s);
		}else{
			ph = 1;
		}
		return ph;
	}
	
	/**
	 * ����11111-99999֮��������
	 * @return
	 */
	public static int getRandom(){
		Random ran = new Random();
		int r = (ran.nextInt(99999))%88889 + 11111;
		return r;
	}

}
