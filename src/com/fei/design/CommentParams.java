package com.fei.design;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.fei.Entity.UserDynamics;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

public class CommentParams extends ReceiveParams {

	public CommentParams(String prms, HttpServletRequest request) {
		super(prms, request);
	}
	
	
	@Override
	public boolean isFormat() {
		// 判断三个参数格式
		boolean flag = false;
		boolean a = Utils.judgeUserName(parms.get(FinalString.USERNAME)[0]);
		System.out.println(parms.get(FinalString.COMMENTCONTENT)[0]);
		boolean b = "".equals(parms.get(FinalString.COMMENTCONTENT)[0]);
		if(a&!b)
			flag = true;
		return flag;
	}

	@Override
	public boolean isValid() {
		// 判断 dnid 是否有效
		boolean flag = true;
		try(Session session = Utils.getSession()){
			String sql = "from UserDynamics where dnId = '" + parms.get(FinalString.DYNAMICID)[0] + "'";
			List<UserDynamics> usds = session.createQuery(sql).list();
			if(usds.size() == 1)
				flag = true;
		}catch(Exception e){
			e.printStackTrace();   
		}
		return flag;
	}

}
