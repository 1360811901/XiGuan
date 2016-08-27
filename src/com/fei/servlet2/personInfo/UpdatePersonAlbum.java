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
import com.fei.design2.params.UpdatePersonAlbumParams;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.fileUpload.FileUpload2;
import com.fei.hanlder.UpdatePersonAlbumHandler;

/**
 * 更新用户的相册
 */
public class UpdatePersonAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePersonAlbum() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 更新用户的相册
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		try {
			ParamsString ps = new ParamsString();
			ps.setNeedParams(FinalStringParams.UPDATEPERSONALBUM);

			FileUpload2 file2 = new FileUpload2();
			ServletContext servletContext = this.getServletContext();
			file2.handleInput(request, servletContext);

			FileUploadFactory fileFactory = new FileUploadFactory();
			UpdatePersonAlbumParams params = fileFactory.createFileParams(UpdatePersonAlbumParams.class, file2, ps);

			UpdatePersonAlbumHandler handler = new UpdatePersonAlbumHandler();
			handler.setFileUp(file2);
			
			String result = handler.processHandler(params);
			pw.append(result);
		} catch (ParamsException e) {
			pw.append(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			pw.append(FinalStringError.SYSTEM_ERROR);
		}

	}
}
