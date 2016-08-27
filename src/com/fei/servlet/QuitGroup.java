package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.dao.GroupMemberListOption;
import com.fei.logic.FeiGetRongToken;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 退出群
 */
public class QuitGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuitGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("退出群");
	}

	/**
	 * 退出群
	 * @return 601,571,200,750,602
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		String groupId = request.getParameter(FinalString.GROUPID);
		if(userName == null | groupId == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				if(Utils.judgeUserName(userName)&Utils.judgeGroupId(groupId)){
					//判断是否在群中
					if(GroupMemberListOption.findList(userName, groupId) == null){
						//用户不在群中，不能退群
						rep.append(FinalString.USERNOTINGROUP);
					}else{
						//1.通知融云退群
						if(FeiGetRongToken.quitGroup(userName, groupId)){
							//2.app server 删除群列表数据
							GroupMemberListOption.deleteList(userName, groupId);
							rep.append(FinalString.CODE_SUC);
						}else{
							rep.append(FinalString.QUITGROUP_MODELERROR);
						}
					}
				}else{
					//返回参数格式错误
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				rep.append(FinalString.QUITGROUP_MODELERROR);
			}
		}
	}

}
