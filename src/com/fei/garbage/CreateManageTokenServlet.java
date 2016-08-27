package com.fei.garbage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.util.ManageToken;
import com.fei.util.Util;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CreateManageTokenServlet
 */
public class CreateManageTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreateManageTokenServlet() {
        super();
    }

	/**
	 *获取前端固定标识字符串
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageToken manageToken = Util.createManageToken(request.getSession().getId());
		JSONObject jo = JSONObject.fromObject(manageToken);
		System.out.println(jo);
		response.getWriter().append(jo.toString());
		
	}

	/**
	 * 如果是post请求则将请求转到get请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
