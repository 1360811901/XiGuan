package com.fei.fileUpload;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fei.design2.Tools;
import com.fei.tools.FinalString;

import net.sf.json.JSONObject;

/**
 * 1.将上传的文件重命名并且保存 2.将保存文件的相应信息返回 3.将普通字段信息返回
 * 
 * @author Administrator
 *
 */
public class FileUpload2 extends FileUp {
	//private Map<String, String> formField = new HashMap<String, String>();
	private List<FileItem> fileItem = new ArrayList<FileItem>();
	private HashSet<Integer> set;
	private JSONObject[] fileMsg = new JSONObject[6];

/*	public Map<String, String> getFormField() {
		return formField;
	}*/

	public JSONObject[] getFileMsg() {
		return fileMsg;
	}

	// 处理上传流
	public void handleInput(HttpServletRequest request, ServletContext servletContext) throws Exception {
		// 1. 判断是否是文件上传
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) { // 上传的方式是multi
			// 创建一个文件上传解析器
			ServletFileUpload upload = Tools.createFileItemFactory(servletContext);
			// 解析请求
			List<FileItem> items = upload.parseRequest(request);
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
					/*
					 * String fieldName = item.getFieldName(); String fileName =
					 * item.getName(); String contentType =
					 * item.getContentType(); long sizeInBytes =
					 * item.getSize()/1024; // 单位是千字节 // 获取文件的后缀名 String suffix
					 * = fileName.substring(fileName.lastIndexOf("."));
					 * 
					 * // 重命名之后的文件名是 String whole = noRepeatFileName(String
					 * userId) + suffix;
					 */
					fileItem.add(item);
				}
			}

			// 将文件写入disk 并将相应的信息返回
			for (int i = 0; i < fileItem.size(); i++) {
				FileItem aitem = fileItem.get(i);
				String fieldName = aitem.getFieldName();
				String fileName = aitem.getName();
				String contentType = aitem.getContentType();
				String sizeInBytes = "" + aitem.getSize() / 1024; // 单位是千字节
				// 获取文件的后缀名
				String suffix = fileName.substring(fileName.lastIndexOf("."));

				// 重命名之后的文件名是
				String whole = noRepeatFileName(formField.get("userId")) + suffix;

				// 保存文件的路径
				String path = servletContext.getRealPath("/") + FinalString.IMG + formField.get("flag") + "\\";
				System.out.println(path);
				// 文件的保存路径
				File directory = new File(path);
				// 如果文件夹不存在则创建
				if (!directory.exists() && !directory.isDirectory()) {
					directory.mkdir();
				}
				File uploadedFile = new File(path, whole);
				aitem.write(uploadedFile);

				// 文件的uri
				String uri = "/img/" + formField.get("flag") + "/" + whole;
				JSONObject js = new JSONObject();
				js.accumulate("url", uri);
				js.accumulate("photeType", contentType);
				js.accumulate("fileName", whole);
				js.accumulate("size", sizeInBytes);
				js.accumulate("sort", fieldName);
				this.fileMsg[i] = js;
			}

		}
	}

	/**
	 * 随机指定范围内N个不重复的数 利用HashSet的特征，只能存放不同的值
	 * 
	 * @param min
	 *            指定范围最小值
	 * @param max
	 *            指定范围最大值
	 * @param n
	 *            随机数个数
	 * @param HashSet<Integer>
	 *            set 随机数结果集
	 */
	private void randomSet(int min, int max, int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (n > (max - min + 1) || max < min) {
			this.set = set;
		}
		for (int i = 0; i < n; i++) {
			// 调用Math.random()方法
			int num = (int) (Math.random() * (max - min)) + min;
			set.add(num);// 将不同的数存入HashSet中
		}
		int setSize = set.size();
		// 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
		if (setSize < n) {
			randomSet(min, max, n - setSize);// 递归
		}
		this.set = set;
	}

	private String noRepeatFileName(String userId) {
		randomSet(0, 1000, 9);
		Iterator<Integer> iterator = this.set.iterator();
		int a = (int) iterator.next();
		// 对文件进行重命名防止重复
		String realName = userId + FinalString.J + System.currentTimeMillis() + a;
		return realName; // 不包含后缀名
	}

}
