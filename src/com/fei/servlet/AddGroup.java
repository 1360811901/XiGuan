package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.dao.GroupMemberListOption;
import com.fei.dao.GroupOption;
import com.fei.logic.FeiGetRongToken;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 加入群
 */
public class AddGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddGroup() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 加入群
	 * @return601,731,200,602,730,732
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		String groupId = request.getParameter(FinalString.GROUPID);
		String groupName = request.getParameter(FinalString.GROUPNAME);
		if(userName == null | groupId == null | groupName == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				if(Utils.judgeUserName(userName)&Utils.judgeGroupId(groupId)&"".equals(groupName)){
					//判断此群是否存在
					if(GroupOption.findGroup(groupId) == null){
						rep.append(FinalString.GROUP_NOTEXIT);
					}else{
						//判断是否已经加群
						if(GroupMemberListOption.findList(userName,groupId) == null){
							// 向融云发送信息将此用户加入群组
							if(FeiGetRongToken.addGroup(userName, groupId, groupName)){
								GroupMemberListOption.insertList(userName, groupId);
								rep.append(FinalString.CODE_SUC);
							}else{
								rep.append(FinalString.ADDGROUP_MODELERROR);
							}
							
						}else{
							rep.append(FinalString.GROUP_EXIT);
						}
						
					}
				}else{
					//返回参数格式错误
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				rep.append(FinalString.ADDGROUP_MODELERROR);
			}
		}
	}

}
