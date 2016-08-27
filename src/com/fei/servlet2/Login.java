package com.fei.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.LoginParamsFactory;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.LoginParams;
import com.fei.feithrows.FeiException;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.LoginHandler;

/**
 * 登陆
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 登陆服务器 1. 可以使用第三方账号登陆（威信、围脖等第三方账号） 2. 可以使用自己账号登陆
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// 创建 pojo params
		try {
			LoginParamsFactory factory = new LoginParamsFactory();
			LoginParams loginParams = factory.createLoginParam(FinalStringParams.LOGIN, request, LoginParams.class);
			LoginHandler loginHandler = new LoginHandler();
			// 登录成功返回相应的access_token 信息
			String result = loginHandler.loginProcess(loginParams.getUserId(), loginParams.getPassWordClear());
			pw.append(result);
		} catch (ParamsException e) {
			pw.append(e.toString());
		} catch (FeiException e) {
			pw.append(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			pw.append(FinalStringError.SYSTEM_ERROR);
		}

	}

}
