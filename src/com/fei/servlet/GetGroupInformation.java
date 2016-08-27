package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.Entity.GroupBaseInformation;
import com.fei.dao.GroupOption;
import com.fei.tools.FinalString;

import net.sf.json.JSONArray;

/**
 * 获取群信息
 */
public class GetGroupInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetGroupInformation() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 获取群信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		if(userName == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				// 当找不到数据时返回空数组
				List<GroupBaseInformation> gs = GroupOption.getGroup(userName);
				if(gs == null)
					rep.append(FinalString.GETGROUPINFORMATION_ERROR);
				
				if(gs.size() == 0)
					rep.append(FinalString.CURRENTCUSTOMER_NOTGROUP);
				
				if(gs.size() >= 1){
					JSONArray ja = JSONArray.fromObject(gs);
					rep.append(FinalString.TOU + "groups" + FinalString.ZHONG + ja.toString() + FinalString.WEI);
				}
					
				
			}catch(Exception e){
				rep.append(FinalString.GETGROUPINFORMATION_ERROR);
			}
		}
	}

}
