package com.fei.servlet2.personInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.Factory;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.UpdatePersonInfoParams;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.Handler;
import com.fei.hanlder.UpdatePersonInfoHandler;

/**
 * 更改个人信息 1.根据提供的参数修改个人信息 2.一次只能修改一个
 */
public class UpdatePersonInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePersonInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 更改个人信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		try{
			Factory factory = new Factory();
			UpdatePersonInfoParams infoParams = factory.createFactory(FinalStringParams.UPDATEPERSONINFO, request, UpdatePersonInfoParams.class);
			
			Handler updateInfo = new UpdatePersonInfoHandler();
			String result = updateInfo.processHandler(infoParams);
			pw.append(result);
		}catch(ParamsException e){
			pw.append(e.toString());
		}catch(Exception e){
			e.printStackTrace();
			pw.append(FinalStringError.SYSTEM_ERROR);
		}
	}

}
