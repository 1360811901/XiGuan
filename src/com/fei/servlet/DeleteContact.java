package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.daoImpl.ContactsListDAOImp;
import com.fei.rong.Rong;
import com.fei.tools.FinalString;

/**
 * 删除好友
 */
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 删除好友
	 * @return 601,200,761
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String userName = request.getParameter(FinalString.USERNAME);
		String contact = request.getParameter(FinalString.CONTACT);
		if(userName == null | contact == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			try{
				// 从数据库中删除联系记录
				ContactsListDAOImp conI = new ContactsListDAOImp();
				conI.deleteContact(userName, contact);
				//仅仅只是删除己方的记录
				//删除对方的记录
				conI.deleteContact(contact, userName);
				//往前端发送命令消息
				Rong.sendPrivateOrderMessage(userName, contact);
				rep.append(FinalString.CODE_SUC);
			}catch(Exception e){
				rep.append(FinalString.DELETECONTACT_MODELERROR);
			}
		}
	}

}
