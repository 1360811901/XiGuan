package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * Servlet implementation class ResetPassWord
 */
public class ResetPassWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	       
    public ResetPassWord() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 重置密码
	 * @return 601,200,600,602,720
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		String black_passWord = request.getParameter(FinalString.PASSWORD);
		if(userName == null | black_passWord ==null ){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				//解密并且去盐
				String salt = Utils.getFromBase64(black_passWord).substring(0, 11);
				//数组下标是从零开始
				String passWord = Utils.getFromBase64(black_passWord).substring(11);
				// 判断参数格式是否正确
				if(Utils.judgeUserName(userName)&Utils.judgePassWord(passWord)&Utils.judgeSalt(salt)){
					if(Utils.updataUser_baseinformationPassW(userName, passWord)){
						rep.append(FinalString.CODE_SUC);
					}else{
						rep.append(FinalString.CODE_FAI);
					}
				}else{
					//返回参数格式错误
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				e.printStackTrace();
				rep.append(FinalString.RESETPASSWORD_MODELERROR);
			}
		}
	}

}
