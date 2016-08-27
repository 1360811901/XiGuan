package com.fei.hanlder;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.fei.daoImpl.UserBaseInformationDAOImp;
import com.fei.design2.Params;
import com.fei.design2.params.UpdatePersonImgParams;
import com.fei.feithrows.FinalStringError;
import com.fei.tools.FinalString;

/**
 * 1. params url 的值延迟到这里来设置 2. 将file 保存到硬盘中 3. 将url 信息保存到数据库中 4. 一次一张图片
 * 
 * @author Administrator
 *
 */
public class FileUploadHandler extends Handler {
	private String rootUrl; // url 根据部署的环境动态生成
	private HashSet<Integer> set;
	private List<FileItem> fileItem;

	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
	}

	public void setFileItem(List<FileItem> fileItem) {
		this.fileItem = fileItem;
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

	private String noRepeatFileName(Params upp) {
		randomSet(0, 1000, 9);
		Iterator<Integer> iterator = this.set.iterator();
		int a = (int) iterator.next();
		// 对文件进行重命名防止重复
		String realName = upp.getUserId() + FinalString.J + System.currentTimeMillis() + a;
		return realName;
	}

	private String saveImg(String realName, String flag) throws Exception {
		String complete = "";
		for (int i = 0; i < this.fileItem.size(); i++) {
			FileItem file = this.fileItem.get(i);
			String fileName = file.getName();
			String contentType = file.getContentType();
			System.out.println("contentType:" + contentType);
			// 获取文件的后缀名
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(suffix);
			// 文件的完整名字是
			complete = realName + suffix;
			// 文件的保存路径
			String path = this.rootUrl + flag;
			File directory = new File(path);
			// 如果文件夹不存在则创建
			if (!directory.exists() && !directory.isDirectory()) {
				directory.mkdir();
			}
			File uploadedFile = new File(path, complete);
			file.write(uploadedFile);
			
		}
		return complete;
	}

	@Override
	public String processHandler(Params p) {
		UpdatePersonImgParams imgp = (UpdatePersonImgParams) p;
		String name = noRepeatFileName(p);
		String flag = imgp.getFlag();
		try {
			String pathName = saveImg(name, flag);
			// 数据库中应该保存相对路径
			imgp.setImgUrl("/img/" +imgp.getFlag() + "/" + pathName);
			saveMySQL(imgp);
			return "{\"code\":200,\"causeBy\":\"update img is ok >>>>\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FinalStringError.SYSTEM_ERROR;
	}

	private void saveMySQL(UpdatePersonImgParams p) {
		UserBaseInformationDAOImp userDao = new UserBaseInformationDAOImp();
		Map<String, String> content = new HashMap<String, String>();
		content.put(p.getFlag(), p.getImgUrl());
		try {
			userDao.update(content, p.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
