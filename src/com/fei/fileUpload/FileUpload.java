package com.fei.fileUpload;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fei.design2.Tools;

public class FileUpload extends FileUp{
	private HttpServletRequest request;
	//private Map<String, String> formField = new HashMap<String, String>();
	private List<FileItem> fileItems = new ArrayList<FileItem>();

	/*public Map<String, String> getFormField() {
		return formField;
	}*/

	public List<FileItem> getFileItems() {
		return fileItems;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 将request 解析成相应的map 和 list
	 * 
	 * @throws FileUploadException
	 * @throws UnsupportedEncodingException
	 */
	public void process(ServletContext servletContext) throws FileUploadException, UnsupportedEncodingException {
		// 1. 判断是否是文件上传
		boolean isMultipart = ServletFileUpload.isMultipartContent(this.request);
		if (isMultipart) { // 上传的方式是multi
			/*// 设置一个简单的配置场景
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 使用默认的配置
			// 设置场景的默认临时文件的存储位置是 servlet 的tempdir
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			// 创建一个文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);*/
			ServletFileUpload upload = Tools.createFileItemFactory(servletContext);
			// 解析请求
			List<FileItem> items = upload.parseRequest(this.request);
			// 处理上传的条目
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				// 判断是formField 还是file
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					this.formField.put(name, value);

				}
				// 是文件
				if (!item.isFormField()) {
					this.fileItems.add(item);
				}
			}

		}
	}

}
