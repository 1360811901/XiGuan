package com.fei.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fei.logic.DynamicHanlder;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

/**
 * 发布个人动态
 */
public class PublisPersonalDynamic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PublisPersonalDynamic() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("jindongfei");
	}

	/**
	 * 发布个人动态
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter rep = response.getWriter();
		try{
			//判断是否是一个文件上传请求
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart){
				//设置一个简单的配置场景
				DiskFileItemFactory factory = new DiskFileItemFactory(); // 使用默认值设置场景
				// 设置场景的默认临时文件的存储位置是servlet 的 tempdir
				ServletContext servletContext = this.getServletConfig().getServletContext();
				File respository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(respository);
				//创建一个文件上传处理器
				ServletFileUpload upload = new ServletFileUpload(factory);
				//解析请求
				List<FileItem> items = upload.parseRequest(request);
				//处理上传的条目
				Iterator<FileItem> iter = items.iterator();
				//保存普通字段信息
				Map<String,String> params = new HashMap<String,String>();
				//保存文件字段信息
				List<FileItem> fitems = new ArrayList<FileItem>();
				// 对items 进行分类
				while(iter.hasNext()){
					FileItem item = iter.next();
					// 如果是普通字段
					if(item.isFormField()){
						String name = item.getFieldName();
						String value = item.getString("UTF-8");
						params.put(name, value);
					}
					// 如果是文件上传字段
					if(!item.isFormField()){
						fitems.add(item);
						/*String name = item.getFieldName();
						String fileName = item.getName();
						String contentType = item.getContentType();
						//获取tomcat项目根目录的绝对路径
						String s = servletContext.getRealPath("/");
   						//将file 保存到文件夹中
						System.out.println(s);
						File uploadedFile = new File(s + FinalString.IMG,"jindongfei.jpg");
						item.write(uploadedFile);*/
					}
				}
				//处理两种item
				System.out.println(params.get("dynamicsContent"));
				//1. 判断两种item 的正确性
				if(Utils.judegMapKey(params, FinalString.MAPKEY)&Utils.judgeFileType(fitems, FinalString.FILETYPE)&Utils.judgeMapValue(params)&fitems.size()<=9){
					DynamicHanlder dh = new DynamicHanlder();
					String rootPath = servletContext.getRealPath("/") + FinalString.IMG;
					dh.createHanlder(params, fitems, rootPath);
					rep.append(FinalString.CODE_SUC);
				}else{
					rep.append(FinalString.ARGUMENTS_FORMATERROR);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			rep.append(FinalString.UPLOADMESSAGE_MODELERROR);
		}
		
		
	}

}
