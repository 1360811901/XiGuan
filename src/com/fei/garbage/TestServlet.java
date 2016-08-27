package com.fei.garbage;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.tools.FinalString;
import com.fei.util.MySessionContext;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		MySessionContext myc = (MySessionContext) application.getAttribute("code_map");
		myc.AddSession("18288888888", 456132);
		System.out.println(myc.getSession("18253597846"));
		response.getWriter().append("Served at: 1232132323313").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ServletContext application = this.getServletContext();
		MySessionContext myc = (MySessionContext) application.getAttribute("code_map");
		myc.AddSession("18288888888", 456132);
		System.out.println("sdfsfdfdfdsd:" + myc.getSession("18253597846"));
		response.getWriter().append("Served at: 1232132323313").append(request.getContextPath());*/
		// TODO Auto-generated method stub
		//doGet(request, response);
		String rootPath = this.getServletContext().getRealPath("/") + FinalString.IMG;
		System.out.println(rootPath);
	}

}
