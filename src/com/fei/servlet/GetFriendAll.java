package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.logic.FeiGetContacts;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 返回好友信息
 */
public class GetFriendAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetFriendAll() {
        super();
    }
    /**
     * 返回好友信息
     * @return 601,605,602,690,userInformation
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		if(userName == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			if(Utils.judgeUserName(userName)){
				String result = FeiGetContacts.getContacts(userName);
				if(result == null){
					rep.append(FinalString.SYSTEM_ERROR);
				}else{
					if("690".equals(result.substring(9, 12))){
						rep.append(result);
					}else{
						rep.append("{\"code\":200,\"contacts\":" + result + "}");
					}
				}
			}else{
				//返回参数格式错误
				rep.append(FinalString.ARGUMENTS_FORMATERROR);
			}
		}
	}

}
