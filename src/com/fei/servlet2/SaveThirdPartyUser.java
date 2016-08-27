package com.fei.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.LoginParamsFactory;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.ThirdPartyLoginParams;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.ThirdPartyLoginHandler;

/**
 * 保存第三方用户信息，第三方的用户信息比本地user相应的信息要多
 */
public class SaveThirdPartyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveThirdPartyUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 保存第三方的用户信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		try {
			// 创建params pojo
			LoginParamsFactory loginParamsFactory = new LoginParamsFactory();
			ThirdPartyLoginParams thirdPartyLoginParams = loginParamsFactory
					.createLoginParam(FinalStringParams.SAVETHIRDPARTYUSER, request, ThirdPartyLoginParams.class);
			// 调用handler 处理程序
			ThirdPartyLoginHandler thirdHandler = new ThirdPartyLoginHandler();
			String result = thirdHandler.processHandler(thirdPartyLoginParams);
			pw.append(result);
		} catch (ParamsException e) {
			pw.append(e.toString());
		} catch (Exception e) {
			pw.append(FinalStringError.SYSTEM_ERROR);
			e.printStackTrace();
		}
	}

}
