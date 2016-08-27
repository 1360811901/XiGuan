package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.logic.FeiGetPassWord;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 返回密码
 */
public class GetPassW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPassW() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 返回密码
	 * return 601,655,602,603,605,password
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		if(userName == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			if(Utils.judgeUserName(userName)){
				//查询密码
				String getResult = FeiGetPassWord.getPassWrod(userName);
				if(getResult == null){
					rep.append(FeiGetPassWord.getResult());
				}else{
					//对密码进行加密
					try{
						String blackPassWord = Utils.getBase64(FinalString.PASSWORD_SALT + getResult);
						rep.append("{\"code\":\"200\",\"passWord\":\"" + blackPassWord + "\"}");
					}catch(Exception e){
						rep.append(FinalString.PASSWORDBLACK_ERROR);
					}
					
				}
			}else{
				//返回参数格式错误
				rep.append(FinalString.ARGUMENTS_FORMATERROR);
			}
		}
	}

}
