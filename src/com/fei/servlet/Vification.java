package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fei.logic.FeiMobileCodeVerification;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;
import com.fei.util.MySessionContext;


/**
 * 验证验证码
 */
public class Vification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(Vification.class);
       
    public Vification() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 验证用户的验证码是否正确
	 * @return601,645,602,641,200,640
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter rep = response.getWriter();
		String phoneNumber = request.getParameter(FinalString.PHONENUMBER);
		String mobileCode = request.getParameter(FinalString.MOBLIECODE);
		//判断参数是否缺失
		if(phoneNumber == null | mobileCode == null){
			rep.append(FinalString.ARGUMENTS_ERROR);
		}else{
			//判断参数格式是否正确
			if(Utils.judgeUserName(phoneNumber) & Utils.judgeMobileCode(mobileCode)){
				
				try{
					// 获取上下文环境
					ServletContext sc = this.getServletContext();
					FeiMobileCodeVerification.setMyc((MySessionContext) sc.getAttribute("code_map"));
					String result = FeiMobileCodeVerification.verificationMobileCode(phoneNumber, mobileCode);
					rep.append(result);
				}catch(Exception e){
					logger.error("VERIFICATION MOBILE CODE MODEL IS ERROR!!");
					rep.append(FinalString.MOBILECODEMODEL_ERROR);
				}
				
			}else{
				//返回参数格式错误
				rep.append(FinalString.ARGUMENTS_FORMATERROR);
			}
		}
	}

}
