package com.fei.design;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.fei.tools.FinalString;
import com.fei.tools.Utils;

public class ReceiveParams extends Params{
	
	public ReceiveParams(String prms, HttpServletRequest request) {
		super(prms, request);
	}
	
	public Set<String> getParamsNames(){
		return parms.keySet();
	}
	//验证参数是否缺失
	public boolean isLose(){
		String[] pms = getNeedKeys();
		Set<String> recP = getParamsNames();
		
		// 判断是否缺失或者多余
		if(!(pms.length == recP.size()))
			return false;
		// 判断是否相等
		int count = 0;
		Iterator it = recP.iterator();
		while(it.hasNext()){
			String s = (String) it.next();
			System.out.println(s);
			for(int i =0;i<pms.length;i++){
				if(s.equals(pms[i])){
					count ++;
					break;
				}
			}
		}
		
		if(pms.length == count)
			return true;
		return false;
	}
	//验证格式是否正确
	public boolean isFormat(){
		// 默认只验证用户名
		boolean a = Utils.judgeUserName(parms.get(FinalString.USERNAME)[0]);
		return a;
	};
	//验证参数是否有效
	public boolean isValid(){
		return false;
	}; 
	
	// 是否合法
	public boolean isLegal(){
		return isLose()&&isFormat()&&isValid();
	}
	
}
