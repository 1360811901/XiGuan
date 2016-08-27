package com.fei.garbage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.util.MySessionContext;

/**
 * Servlet implementation class TestServlet2
 */
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	/*	ServletContext sc = this.getServletContext();
		MySessionContext myc = (MySessionContext) sc.getAttribute("code_map");
		String test = request.getParameter("testno");
		System.out.println(test);*/
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("test1", request.getParameter("test1"));
		params.put("test2", request.getParameter("test2"));
		params.put("test3", request.getParameter("test3"));
		params.put("tests", request.getParameter("tests"));
		CheckNull cn = new CheckNull();
		cn.setParams(params);
		boolean flag = cn.checkNull();
		if(flag){
			System.out.println("cn:" + cn.toString());
		}else{
			System.out.println("params access!!!");
		}
		response.getWriter().append("sssssss");
		//System.out.println(myc.getSession("18288888888"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		      public void run() {
		          System.out.println("-------设定要指定任务--------");
		          try {
					response.getWriter().append("超时");
				} catch (IOException e) {
					e.printStackTrace();
				}
		        }
		      }, 2000);*/
		response.getWriter().append("金冬飞");
	}

}
