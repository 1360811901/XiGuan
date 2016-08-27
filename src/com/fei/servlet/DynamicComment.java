package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.Entity.Comment;
import com.fei.daoImpl.CommentDAOImp;
import com.fei.design.CommentParams;
import com.fei.tools.FinalString;

/**
 * 动态评论
 */
public class DynamicComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DynamicComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 动态评论
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		System.out.println(userName);
		String dnid = request.getParameter(FinalString.DYNAMICID);
		String comment = request.getParameter(FinalString.COMMENTCONTENT);
		try{
			CommentParams cp = new CommentParams(FinalString.COMMENT_PARAMS_STRING,request);
			if(cp.isLegal()){
				Comment com = new Comment();
				com.setDynamicId(dnid);
				com.setUserName(userName);
				com.setContent(comment);
				com.setcTime("" + System.currentTimeMillis());
				CommentDAOImp ci = new CommentDAOImp();
				ci.save(com);
				rep.append(FinalString.CODE_SUC);
			}else{
				rep.append(FinalString.PARAMS_ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
			rep.append(FinalString.COMMENT_MODELERROR);
		}
		
	}

}
