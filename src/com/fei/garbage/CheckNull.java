package com.fei.garbage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckNull {
	
	private Map<String,Object> params;
	private Map<String,String> error = new HashMap<String,String>();
	
	/**
	 * 判断params 是否为null 或者 为 ""
	 * @return
	 */
	public boolean checkNull(){
		Iterator<Map.Entry<String, Object>> iter = params.entrySet().iterator();
		boolean flag = false;
		String s = null;
		while(iter.hasNext()){
			Map.Entry<String, Object> ent = iter.next();
			s = ent.getKey();
			if(ent.getValue() == null){
				error.put(s, s + " is null");
				flag = true;
			}else if(ent.getValue() == ""){
				error.put(s, s + " is empty String");
				flag = true;
			}
		}
		return flag;
	}

	public Map<String, Object> getParams() {
		return params;
	}
	/**
	 * 设置params
	 * @param params
	 */
	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}
	/**
	 * 返回参数的空值信息
	 */
	public String toString(){
		String s = "";
		if(error != null){
			Iterator<Map.Entry<String, String>> iter = error.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> ent = iter.next();
				s += ent.getValue() + ",";
			}
			s = s.substring(0,s.length()-1);
		}
		return s;
	}
}
