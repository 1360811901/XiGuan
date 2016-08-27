package com.fei.design2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ServletParams {

	private Map<String, String[]> parms;

	@SuppressWarnings("unchecked")
	public void setParms(HttpServletRequest request) {
		this.parms = request.getParameterMap();
	}

	public Map<String, String[]> getParms() {
		return parms;
	}

	@Override
	public String toString() {
		String queryString = "";
		if (parms.size() != 0) {
			for (String key : parms.keySet()) {
				String[] values = parms.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					queryString += key + "=" + value + "&";
				}
			}
			// 去掉最后一个& 字符
			queryString = queryString.substring(0, queryString.length() - 1);
			System.out.println("requestParams@" + queryString);
		}
		return queryString;
	}

}
