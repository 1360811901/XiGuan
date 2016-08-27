package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.mongodb.Mongo;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 返回附近的人信息
 */
public class NearPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NearPeople() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 返回附近的人的信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// 需要地理位置信息
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String userId = request.getParameter(FinalString.USERNAME);
		
		// 判断参数
		if(!(Utils.judgeUserName(userId)&longitude != null& latitude !=null)){
			pw.append(FinalString.PARAMS_ERROR);
		}else{
			try{
				double x = Double.parseDouble(longitude);
				double y = Double.parseDouble(latitude);
				// 将 位置信息保存到mongodb 中
				Mongo.insertOneDoc(userId, x, y);
				String result = Mongo.getRangePer(x,y);
				pw.append(result);
			}catch(Exception e){
				e.printStackTrace();
				pw.append(FinalString.NEARBYPEOPLE_MODELERROR);
			}
		}
			
		
	}

}
