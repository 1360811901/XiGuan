package com.fei.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.LoginParamsFactory;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.ValidateSMSCodeParams;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.ValidateSMSCodeHandler;

/**
 * 验证短信验证码
 */
public class ValidateSMSCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateSMSCode() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 验证短信验证码
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		try {
			LoginParamsFactory paramsFactory = new LoginParamsFactory();
			ValidateSMSCodeParams codeParams = paramsFactory.createLoginParam(FinalStringParams.VALIDATESMSCODE,
					request, ValidateSMSCodeParams.class);

			ValidateSMSCodeHandler handler = new ValidateSMSCodeHandler();
			String result = handler.processHandler(codeParams);
			pw.append(result);
		} catch (ParamsException e) {
			pw.append(e.toString());
		} catch (Exception e) {
			pw.append(FinalStringError.SYSTEM_ERROR);
			e.printStackTrace();
		}
	}

}
