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
import com.fei.hanlder.ResetPassWordHandler;

/**
 * 重置密码
 */
public class ResetPassWord_v2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPassWord_v2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 重置密码
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		try{
			// 新建 params pojo 对象
			LoginParamsFactory paramsFactory = new LoginParamsFactory();
			SaveUser_v2Params updateParams = paramsFactory.createLoginParam(FinalStringParams.SAVEUSER_V2, request, SaveUser_v2Params.class);
			
			ResetPassWordHandler resetPassWord = new ResetPassWordHandler();
			String result = resetPassWord.processHandler(updateParams);
			pw.append(result);
		}catch(ParamsException e){
			pw.append(e.toString());
		}catch(Exception e){
			e.printStackTrace();
			pw.append(FinalStringError.SYSTEM_ERROR);
		}
	}

}
