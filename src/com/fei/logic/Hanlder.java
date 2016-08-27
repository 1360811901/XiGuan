 package com.fei.logic;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.fei.feithrows.FileItemToWriteException;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

public abstract class Hanlder {
	protected HashSet<Integer> noRepeatRan = Utils.randomSet(0, 1000, 9);
	protected Map<String,String> formField;
	protected List<FileItem> fitems;
	protected String rootPath;
	protected Map[] fileInfo = new Map[9];
	protected String dnId;
	
	// 生成dnid
	protected void createDnId(){
		formField.get(FinalString.USERNAME);
	}
	/**
	 * 将文件重命名保存到硬盘中,并将相应的信息放在数组中字段中
	 * @throws Exception
	 */
	protected void itemToWrite() throws Exception{
		//创建保存的路径
		String path = rootPath;
		File uploadedFile = null;
		Iterator<Integer> it = noRepeatRan.iterator();
		for(int i = 0;i<fitems.size();i++){
			FileItem item = fitems.get(i);
			String fileName = item.getName();
			String tsize = "" + (item.getSize()/1024);
			// 对文件进行重命名防止重复
			String realName = formField.get(FinalString.USERNAME) + FinalString.J + System.currentTimeMillis() + it.next();
			// 获取文件的后缀名
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			//文件的完整名字是
			String complete = realName+suffix;
			uploadedFile = new File(path,complete);
			item.write(uploadedFile);
			
			// 将相应的信息保存到JSONArray
			Map<String,String> photoInfo = new HashMap<String,String>();
			photoInfo.put("url", path+complete);
			photoInfo.put("fileName", complete);
			photoInfo.put("size",tsize);
			photoInfo.put("dynamicId", dnId);
			fileInfo[i] = photoInfo;
		}
	}
	/**
	 * 将formfield信息保存到数据库中
	 */
	public abstract void saveFormEntity();
	/**
	 * 将file 信息保存到数据库中
	 */
	public abstract void saveFileEntity();
	
	public void createHanlder(Map<String,String> formField,List<FileItem> fitems,String rootPath) throws Exception{
		this.formField = formField;
		this.fitems = fitems;
		this.rootPath = rootPath;
		this.dnId = formField.get(FinalString.USERNAME) + FinalString.J + System.currentTimeMillis();
		try {
			itemToWrite();
		} catch (Exception e) {
			throw e;
		}
		saveFormEntity();
		saveFileEntity();
	}
}
