package com.fei.design2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SingletonTools {
	private static final SingletonTools singletonTools = new SingletonTools();

	// 只能自己使用构造方法
	private SingletonTools() {
	}

	// 返回一个单实例
	public static SingletonTools getSingleInstance() {
		return singletonTools;
	}

	/* 工具方法 */
	/**
	 * 判断keys 是否正好
	 * 
	 * @param ps
	 * @param sp
	 * @return
	 */
	public boolean matchKeys(String[] ps, Map<String, String[]> sp) {
		String[] pms = ps;
		Set<String> recP = sp.keySet();
		// 判断是否缺失或者多余
		if (!(pms.length == recP.size()))
			return false;
		// 判断是否相等
		int count = 0;
		Iterator<String> it = recP.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			for (int i = 0; i < pms.length; i++) {
				if (s.equals(pms[i])) {
					count++;
					break;
				}
			}
		}

		if (pms.length == count)
			return true;
		return false;
	}

	/**
	 * 判断参数是否缺失
	 * 
	 * @param ps
	 * @param sp
	 * @return
	 */
	public boolean matchKeys(ParamsString ps, ServletParams sp) {
		String[] pms = ps.getNeedKeys();
		Set<String> recp = sp.getParms().keySet();
		String[] rec = (String[]) recp.toArray();
		Arrays.sort(pms);
		Arrays.sort(rec);
		if (Arrays.equals(pms, rec)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断参数是否缺失
	 * 
	 * @param ps
	 * @param recp
	 * @return
	 */
	public boolean matchKeys(ParamsString ps, Set<String> recp) {
		String[] pms = ps.getNeedKeys();
		// 判断是否缺失或者多余
		if (!(pms.length == recp.size()))
			return false;
		// 判断是否相等
		int count = 0;
		Iterator<String> it = recp.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			for (int i = 0; i < pms.length; i++) {
				if (s.equals(pms[i])) {
					count++;
					break;
				}
			}
		}

		if (pms.length == count)
			return true;
		return false;
	}

}
