package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改昵称
 */
public class ChangeNickName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeNickName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 修改昵称
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		// nat (network address translation) ip 地址短缺解决方案
		// nat 穿透
		
	}

}
