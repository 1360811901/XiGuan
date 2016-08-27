package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.Entity.UserBaseInformation;
import com.fei.feithrows.UserBaseInformationException;
import com.fei.logic.FeiGetRongToken;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;


/**
 * 获取融云token
 */
public class RongYunToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RongYunToken() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 获取融云token
	 * @return 601,602,660,662,rongToken,661
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		if(userName == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			if(Utils.judgeUserName(userName)){
				//首先到数据库中查找
				UserBaseInformation userInf = Utils.getBaseInformation(userName);
				if(userInf == null){
					rep.append(FinalString.USERNOTEXIT);
				}else{
					String s = userInf.getRongToken();
					if("".equals(s)){
						//获取融云token
						String result;
						try {
							result = FeiGetRongToken.getRongToken(userName);
							if(FeiGetRongToken.isGetToken()){
								rep.append("{\"code\":200,\"rongToken\":\"" + result + "\"}");
								//获取token 之后将token 保存到数据库
								Utils.updataUser_baseinformation(userName, result);
							}else{
								rep.append(result);
							}
						} catch (UserBaseInformationException e) {
							rep.append(FinalString.GETUSERINFORMATION_ERROR);
						} catch (Exception e) {
							rep.append(FinalString.RONGYUN_ERROR);
						}
					}else{
						rep.append("{\"code\":200,\"rongToken\":\"" + s + "\"}");
					}
				}
				
			}else{
				//返回参数格式错误
				rep.append(FinalString.ARGUMENTS_FORMATERROR);
			}
		}
		
	}

}
