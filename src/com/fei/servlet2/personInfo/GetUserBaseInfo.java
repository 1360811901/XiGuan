package com.fei.servlet2.personInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.Factory;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.GetUserBaseInfoParams;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.GetUserBaseInfoHandler;

/**
 * 获取用户的基本信息
 */
public class GetUserBaseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetUserBaseInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 获取用户的基本信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		try{
			Factory factory = new Factory();
			GetUserBaseInfoParams userInfo = factory.createFactory(FinalStringParams.GETUSERBASEINFO, request, GetUserBaseInfoParams.class);
			
			GetUserBaseInfoHandler handler = new GetUserBaseInfoHandler();
			String result = handler.processHandler(userInfo);
			pw.append(result);
		}catch(ParamsException e){
			pw.append(e.toString());
		}catch(Exception e){
			pw.append(FinalStringError.SYSTEM_ERROR);
		}
	}

}
