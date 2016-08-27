package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.daoImpl.UserDynamicsDAOImp;
import com.fei.tools.FinalString;

/**
 * 点赞
 */
public class ClickOnLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClickOnLike() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}
	/**
	 * 点赞
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String dnId = request.getParameter(FinalString.DYNAMICID);
		if(dnId == null & "".equals(dnId)){
			rep.append(FinalString.ARGUMENTS_FORMATERROR);
		}else{
			try{
				UserDynamicsDAOImp udi = new UserDynamicsDAOImp();
				udi.clickOnLike(dnId);
				rep.append(FinalString.CODE_SUC);
			}catch(Exception e){
				e.printStackTrace();
				rep.append(FinalString.CLICKONLIKE_MODELERROR);
			}
		}
		
	}

}
