package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.Entity.UserBaseInformation;
import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.logic.HibernateSearch;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 搜索用户
 */
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 搜索用户
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String key = request.getParameter("key");
		String userId = request.getParameter("userId");
		System.out.println(key);
		System.out.println(userId);
		if(key == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				if("".equals(key)){
					rep.append(FinalString.KEYWORDS_MISTAKE);
				}else{
					String result;
					// 判断key 是不是 userId
						// 精确通过id来查找用户
						List<UserBaseInformation> usersl = new ArrayList<UserBaseInformation>();
						UserBaseInformation user = Utils.getBaseInformation(key);
						if(user!=null){
							usersl.add(user);
							result = Utils.getInstanceInfo(usersl);
						}else{
							//先进行精确查询
							UserBaseInformationDAOImp  users = new UserBaseInformationDAOImp();
							List<UserBaseInformation> us = users.getUserBaseInfo(key);
							if(us.size() == 0){
								// 使用关键字模糊查询
								result = HibernateSearch.search(key);
							}else{
								result = Utils.getInstanceInfo(us);
							}
						}
					// 返回结果
					rep.append("{\"code\":200,\"result\":" + result + "}");
				}
			}catch(Exception e){
				e.printStackTrace();
				rep.append(FinalString.SEARCH_MODELERROR);
			}
		}
	}

}
