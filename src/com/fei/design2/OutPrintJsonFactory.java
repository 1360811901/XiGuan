package com.fei.design2;

import net.sf.json.JSONObject;

public class OutPrintJsonFactory {
	public String createJsonFactory(String code,String key2,Object o){
		JSONObject js = new JSONObject();
		js.accumulate("code", code);
		js.accumulate(key2, o);
		return js.toString();
	}

}
