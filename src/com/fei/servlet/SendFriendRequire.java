package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.logic.AddFriendMessage;
import com.fei.logic.FeiGetRongToken;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

public class SendFriendRequire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SendFriendRequire() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 向用户发送系统好友请求
	 * @return 601,701,602,700,200
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String sourceUser = request.getParameter(FinalString.SOURCEUSER);
		String targetUser = request.getParameter(FinalString.TARGETUSER);
		String message = request.getParameter(FinalString.MESSAGE);
		if(sourceUser == null | targetUser == null | message == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				// message 可以为""
				if(Utils.judgeUserName(sourceUser)&Utils.judgeUserName(targetUser)){
					List<String> toUserIds = new ArrayList<String>();
					toUserIds.add(targetUser);
					AddFriendMessage afm = new AddFriendMessage();
					afm.setTargetUserId(targetUser);
					afm.setSourceUserId(sourceUser);
					afm.setMessage(message);
					System.out.println(afm);
					String rs = FeiGetRongToken.sendFriendSystemMessage(toUserIds, afm, "", "");
					if("".equals(rs)){
						// 发送好友请求失败
						rep.append(FinalString.SENDFRIEND_FAIL);
					}else{
						rep.append(rs);
					}
				}else{
					//返回参数格式错误
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				e.printStackTrace();
				rep.append(FinalString.REQUESTFRIENDMESSAGE_ERROR);
			}
		}
	}

}
