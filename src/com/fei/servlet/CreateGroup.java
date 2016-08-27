package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.logic.FeiGetRongToken;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 *创建群
 */
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public CreateGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 给我群信息，我换你一个群
	 * @return 601,200,600,602,710
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		String summary = request.getParameter(FinalString.SUMMARY);
		String name = request.getParameter(FinalString.GROUPNAME);
		System.out.println("summary"+summary);
		System.out.println("name"+name);
		System.out.println(userName);
		
		if(userName == null |summary == null | name == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			//将整个逻辑块包起来
			try{
				//判断参数格式
				if(Utils.judgeUserName(userName)&!"".equals(summary)&!"".equals(name)){
					String rs = FeiGetRongToken.createGroup(userName, summary, name);
					if(!"".equals(rs)){
						rep.append(FinalString.TOU + FinalString.GROUPID + FinalString.ZHONG +rs + FinalString.WEI);
					}else{
						rep.append(FinalString.CODE_FAI);
					}
				}else{
					//返回参数格式错误
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				rep.append(FinalString.CREATEGROUP_MODELERROR);
			}
			
		}
	}

}
