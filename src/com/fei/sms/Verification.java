package com.fei.sms;

public interface Verification {
	/**
	 * ����ֵ����֤�Ƚ�
	 * @param arg1
	 * @param arg2
	 * @return �����Ƿ���ȷ
	 */
	public abstract boolean verication(Object arg1,Object arg2);
	/**
	 * ������֤�Ľ��
	 * @param s��������״̬
	 */
	public abstract void handleResult(String s);
}
