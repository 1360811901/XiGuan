package com.fei.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.LoginParamsFactory;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.SendSMSCodeParams;
import com.fei.feithrows.FeiException;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.SendSMSCodeHandler;

/**
 * 发送短信验证码 1. 登陆的时候没有access_token 2. 忘记密码的时候也是没法登陆，也就是没有access_token
 */
public class SendSMSCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendSMSCode() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 发送短信验证码 1.号码 2.stamp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		try {
			LoginParamsFactory loginParamsFactory = new LoginParamsFactory();
			SendSMSCodeParams SMSCodeParams = loginParamsFactory.createLoginParam(FinalStringParams.SENDSMSCODE,
					request, SendSMSCodeParams.class);

			// 处理过程
			SendSMSCodeHandler codeHandler = new SendSMSCodeHandler();
			String result = codeHandler.processHandler(SMSCodeParams);

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
