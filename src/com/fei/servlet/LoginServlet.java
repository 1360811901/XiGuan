package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fei.logic.LoginFeiServer;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;


/**
 * 验证登录
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 前端提供用户名和密码，后台验证用户名和密码是否相匹配，返回正确与否，然后由前端来控制是否能进入下一个功能
	 * 仅仅只验证与否，不保证登录成功之后的状态保存
	 * 服务的请求由前端来保证
	 * @return 200,601,602,603,604,605,606
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		String black_passWord = request.getParameter(FinalString.PASSWORD);
		String flag = request.getParameter("flag");
		//缺失参数
		if(userName == null | black_passWord == null |flag == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				//解密并且去盐
				String salt = Utils.getFromBase64(black_passWord).substring(0, 11);
				//数组下标是从零开始
				String passWord = Utils.getFromBase64(black_passWord).substring(11);
				// 判断参数格式是否正确
				/*boolean a = Utils.judgeUserName(userName);
				boolean b = Utils.judgePassWord(passWord);
				boolean c = Utils.judgeSalt(salt);*/
				if(Utils.judgeUserName(userName)&Utils.judgePassWord(passWord)&Utils.judgeSalt(salt)){
					// 判断用户名密码是否正确
					try{
						rep.append(LoginFeiServer.loginFei(userName, passWord));
					}catch(Exception e){
						e.printStackTrace();
						rep.append(FinalString.LOGIN_FAIL);
						logger.error("LOGIN MODEL IS ERROR!!!!!");
					}
					
				}else{
				//返回参数格式错误
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				e.printStackTrace();
				rep.append(FinalString.BASE64_ISERRORFORMAT);
			}
			
		}
		
	}

}
