package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fei.logic.FeiSaveUser;
import com.fei.tools.FinalString;
import com.fei.tools.JudgeBase64PassWord;
import com.fei.tools.Utils;


/**
 * 保存用户信息
 */
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(SaveUser.class);
	
    public SaveUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 保存用户信息
	 * @return601,602,631,630,200
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		//获取前端发送过来的用户名和密码
		String userName = request.getParameter(FinalString.USERNAME);
		String black_passWord = request.getParameter(FinalString.PASSWORD);
		//缺失参数
		if(userName == null | black_passWord == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			
			try{
				//解密并且去盐
				String salt = Utils.getFromBase64(black_passWord).substring(0, 11);
				//数组下标是从零开始
				String passWord = Utils.getFromBase64(black_passWord).substring(11);
				// 判断参数格式是否正确
				if(Utils.judgeUserName(userName)&Utils.judgePassWord(passWord)&Utils.judgeSalt(salt)){
					
					//保存用户名和密码
					try{
						String result = FeiSaveUser.saveUser(userName, passWord);
						rep.append(result);
					}catch(Exception e){
						rep.append(FinalString.SAVEUSERMODEL_ERROR);
						logger.error("SAVE USER IS FAIL, USERNAME : " + userName + "PASSWORD : " + passWord);
					}
				}else{
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				rep.append(FinalString.BASE64_ISERRORFORMAT);
			}
			
			
		}
		
	}

}
