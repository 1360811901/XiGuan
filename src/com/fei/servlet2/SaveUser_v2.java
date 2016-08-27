package com.fei.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.LoginParamsFactory;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.SaveUser_v2Params;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.SaveUser_v2Handler;

/**
 * 保存注册用户
 */
public class SaveUser_v2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveUser_v2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 保存注册用户
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try{
			// 创建params pojo 对象
			LoginParamsFactory loginParamsFactory = new LoginParamsFactory();
			SaveUser_v2Params saveParams = loginParamsFactory.createLoginParam(FinalStringParams.SAVEUSER_V2, request, SaveUser_v2Params.class);
			// 创建 Handler 处理类
			SaveUser_v2Handler handler = new SaveUser_v2Handler();
			String s = handler.processSaveUser_v2(saveParams);
			pw.append(s);
		}catch(ParamsException e){
			pw.append(e.toString());
		}catch(Exception e){
			pw.append(FinalStringError.SYSTEM_ERROR);
			e.printStackTrace();
		}
	}

}
