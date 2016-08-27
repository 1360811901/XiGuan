package com.fei.design;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

abstract class Params implements FilterParams{
	protected String prms;
	protected Map<String, String[]> parms;
	
	public Params(String prms,HttpServletRequest request){
		this.prms = prms;
		this.parms = request.getParameterMap();
	}
	
	protected String[] getNeedKeys(){
		return prms.split("@");
	}
	
	public String getPrms() {
		return prms;
	}
	public void setPrms(String prms) {
		this.prms = prms;
	}
	public Map<String,String[]> getParms() {
		return parms;
	}
	public void setParms(Map<String,String[]> parms) {
		this.parms = parms;
	}
	
}
