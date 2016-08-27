package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.logic.FeiAddContacts;
import com.fei.rong.Rong;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 添加好友
 */
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddFriendServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 添加好友
	 * @return 601,603,200,680,602
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		String contact = request.getParameter(FinalString.CONTACT);
		if(userName == null | contact == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				if(Utils.judgeUserName(userName)&Utils.judgeUserName(contact)&!userName.equals(contact)){
					//保存好友信息
					//判断两个用户名是否存在
					if(Utils.getBaseInformation(userName) == null | Utils.getBaseInformation(contact) == null){
						rep.append(FinalString.USER_NOEXIT);
					}else{
						if(FeiAddContacts.addContact(userName, contact)&FeiAddContacts.addContact(contact, userName)){
							//向两个user 发送两人已经是好友的信息
							List<String> toUserIds = new ArrayList<String>();
							toUserIds.add(0, userName);
							toUserIds.add(1, contact);
							//Rong.sendSystemNotify(toUserIds);
							Rong.sendPrivateMessage(userName, contact);
							Rong.sendPrivateMessage(contact, userName);
							rep.append(FinalString.CODE_SUC);
						}else{
							rep.append(FinalString.CONTACTSAVE);
						}
					}
				}else{
					//返回参数格式错误
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}catch(Exception e){
				e.printStackTrace();
				rep.append(FinalString.SAVECONTACT_MODELERROR);
			}
			
		}
	}

}
