package com.fei.design2;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Tools {

	/**
	 * 判断Number 的格式是否正确
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean matchPhoneNumber(String phoneNumber) {
		String pattern = "^[1][358][0-9]{9}$";
		return Pattern.matches(pattern, phoneNumber);
	}

	/**
	 * 组装params pojo
	 * 
	 * @param cl
	 * @param o
	 * @param slv
	 * @throws Exception
	 */
	public static <T extends Params> void assembleParams(Class<T> cl, Params o, Map<String, String[]> slv)
			throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(cl);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (propertyDescriptors != null && propertyDescriptors.length > 0) {
			String propertyName = null; // javaBean 属性名
			Object propertyValue = null; // javaBean 属性值
			for (PropertyDescriptor pd : propertyDescriptors) {
				propertyName = pd.getName();
				if (slv.containsKey(propertyName)) {
					propertyValue = slv.get(propertyName)[0];
					pd.getWriteMethod().invoke(o, propertyValue);
				}
			}
		}
	}

	/**
	 * 将Map 转换成javabean
	 * 
	 * @param c
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T mapToBean(Class<T> c, Map<String, String> s) {
		try {
			// 获取javaBean 属性
			BeanInfo beanInfo = Introspector.getBeanInfo(c);
			// 创建 javaBean 对象
			Object bean = Class.forName(c.getName()).newInstance();

			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			if (propertyDescriptors != null && propertyDescriptors.length > 0) {
				String propertyName = null; // javaBean 属性名
				Object propertyValue = null; // javaBean 属性值
				for (PropertyDescriptor pd : propertyDescriptors) {
					propertyName = pd.getName();
					if (s.containsKey(propertyName)) {
						propertyValue = s.get(propertyName);
						pd.getWriteMethod().invoke(bean, new Object[] { propertyValue });
					}
				}
				return (T) bean;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 返回一个文件上传处理器 对象
	 * @return
	 */
	public static ServletFileUpload createFileItemFactory(ServletContext servletContext){
		// 设置一个简单的配置场景
		DiskFileItemFactory factory = new DiskFileItemFactory(); // 使用默认的配置
		// 设置场景的默认临时文件的存储位置是 servlet 的tempdir
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// 创建一个文件上传处理器
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		return upload;
	}

}
