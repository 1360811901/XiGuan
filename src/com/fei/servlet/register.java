package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fei.logic.FeiSendSMS;
import com.fei.tools.FinalString;
import com.fei.util.MySessionContext;


/**
 * 提供手机号发送验证码
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(register.class);
       
    public register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 *只要提供电话号码就能发送发送验证码
	 *@return 601,602,610,200
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String phoneNumber = request.getParameter(FinalString.PHONENUMBER);
		if(phoneNumber == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			//判断电话号码的格式是否正确
			if(com.fei.tools.Utils.judgeUserName(phoneNumber)){
				FeiSendSMS sendSMS = new FeiSendSMS();
				//短信发送成功
				try{
					if(sendSMS.sendSMS(phoneNumber)){
						ServletContext sc = this.getServletContext();
						MySessionContext myc = (MySessionContext) sc.getAttribute("code_map");
						myc.AddSession(phoneNumber, sendSMS.getSend_code());
						System.out.println("send code:" + sendSMS.getSend_code());
						rep.append(FinalString.CODE_SUC);
						logger.info("SEND SMS " + phoneNumber + "IS SUCCESS !!");
					}else{
						rep.append(FinalString.SENDCODE_FAIL);
					}
				}catch(Exception e){
					rep.append(FinalString.SENDCODE_MODEL);
					logger.error("SEND SMS" + phoneNumber + "IS ERROR !!");
				}
				
			}else{
				//返回参数格式错误
				rep.append(FinalString.ARGUMENTS_FORMATERROR);
			}
		}
		
	}

}
