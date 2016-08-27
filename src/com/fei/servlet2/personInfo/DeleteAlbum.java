package com.fei.servlet2.personInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.design2.Factory;
import com.fei.design2.params.DeleteAlbumParams;
import com.fei.design2.params.FinalStringParams;
import com.fei.feithrows.FeiException;
import com.fei.feithrows.FinalStringError;
import com.fei.feithrows.ParamsException;
import com.fei.hanlder.DeleteAlbumHandler;

/**
 * 删除相册一张照片
 */
public class DeleteAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAlbum() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 删除相册的一张照片
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		try{
			Factory factory = new Factory();
			DeleteAlbumParams albumParams = factory.createFactory(FinalStringParams.DELETEALBUM, request, DeleteAlbumParams.class);
			
			DeleteAlbumHandler handler = new DeleteAlbumHandler();
			String result = handler.processHandler(albumParams);
			
			pw.append(result);
		}catch(ParamsException e){
			pw.append(e.toString());
		}catch(FeiException e){
			pw.append(e.toString());
		}catch(Exception e){
			pw.append(FinalStringError.SYSTEM_ERROR);
		}
		
	}

}
