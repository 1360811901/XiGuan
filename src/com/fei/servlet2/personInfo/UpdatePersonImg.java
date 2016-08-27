package com.fei.servlet2.personInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.FileUploadFactory;
import com.fei.design2.ParamsString;
import com.fei.design2.params.FinalStringParams;
import com.fei.design2.params.UpdatePersonImgParams;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.fileUpload.FileUpload;
import com.fei.hanlder.FileUploadHandler;
import com.fei.tools.FinalString;

/**
 * 更新用户的图片信息
 */
public class UpdatePersonImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePersonImg() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 更新用户的图片信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ServletContext servletContext = this.getServletContext();
		String rootPath = servletContext.getRealPath("/") + FinalString.IMG;    //C:\Users\Administrator\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\feiServer\
		System.out.println(rootPath);
		
		try{
			ParamsString ps = new ParamsString();
			ps.setNeedParams(FinalStringParams.UPDATEPERSONIMG);
			
			FileUpload fileUpload = new FileUpload();
			fileUpload.setRequest(request);
			fileUpload.process(servletContext);
			
			FileUploadFactory factory = new FileUploadFactory();
			UpdatePersonImgParams imgParams = factory.createFileParams(UpdatePersonImgParams.class, fileUpload, ps);
			
			FileUploadHandler handler = new FileUploadHandler();
			handler.setRootUrl(rootPath);
			handler.setFileItem(fileUpload.getFileItems());
			
			String result = handler.processHandler(imgParams);
			
			pw.append(result);
		}catch(ParamsException e){
			pw.append(e.toString());
		}catch(Exception e){
			e.printStackTrace();
			pw.append(FinalStringError.SYSTEM_ERROR);
		}
		
		
	}

}
