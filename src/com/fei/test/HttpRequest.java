package com.fei.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

	private static final String url = "http://localhost:8088/feiServer";

	/**
	 * 发送post请求
	 * 
	 * @param actUrl
	 * @param params
	 * @author jdf
	 */
	public static void sendPostRequest(String actUrl, String params) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL hostUrl = new URL(url + actUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) hostUrl.openConnection();
			// 设置连接的超时时间
			urlConnection.setConnectTimeout(3000); // 3s 超时
			// 设置请求的方式
			urlConnection.setRequestMethod("POST");
			// 设置客户端能接收的数据类型(和火狐类似)
			urlConnection.setRequestProperty("accept", "*/*");
			urlConnection.setRequestProperty("connection", "keep-alive");// java
																			// 默认就是keep-alive
			urlConnection.setRequestProperty("accept-encoding", "gzip, deflate");
			urlConnection.setRequestProperty("accept-language", "zh-CN,zh;q=0.8");
			urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			urlConnection.setRequestProperty("user-agent", "XiGuan1.0.0(androdi;test;java)");
			urlConnection.setDoOutput(true); // 表示向服务器写数据
			urlConnection.setDoInput(true); // 表示向服务器获取数据
			// 默认的请求头会加上content-length 这个属性
			// 发送字节流
			out = new PrintWriter(urlConnection.getOutputStream());
			out.print(params);
			out.flush();
			// 获取返回信息
			// 1. 获取服务器的返回结果和响应码
			int responseCode = urlConnection.getResponseCode();
			String s = urlConnection.getResponseMessage();
			System.out.println(responseCode);
			if (responseCode == 200) {
				// 将返回的输入流转换成指定编码的字符串
				result = changeInputStream(urlConnection.getInputStream(), "utf-8");
			} else {
				System.out.println(responseCode);
				System.out.println(s);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		// 将返回的结果在控制台输出
		System.out.println(result);
	}

	/**
	 * 发送get 请求
	 * 
	 * @param actUrl
	 * @param params
	 * @author jdf
	 */
	public static void sendGetRequest(String actUrl, String params) {
		BufferedReader in = null;
		String result = "";
		URL hostUrl;
		try {
			hostUrl = new URL(url + actUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) hostUrl.openConnection();
			// 设置连接的超时时间
			urlConnection.setConnectTimeout(3000); // 3s 超时
			// 设置请求的方式
			urlConnection.setRequestMethod("GET");
			// 设置客户端能接收的数据类型(和火狐类似)
			urlConnection.setRequestProperty("accept", "*/*");
			urlConnection.setRequestProperty("connection", "keep-alive");// java
																			// 默认就是keep-alive
			urlConnection.setRequestProperty("accept-encoding", "gzip, deflate");
			urlConnection.setRequestProperty("accept-language", "zh-CN,zh;q=0.8");
			urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			urlConnection.setRequestProperty("user-agent", "XiGuan1.0.0(android;test;java)");
			urlConnection.setDoInput(true);
			// 获取返回信息
			// 1. 获取服务器的返回结果和响应码
			int responseCode = urlConnection.getResponseCode();
			String s = urlConnection.getResponseMessage();
			if (responseCode == 200) {
				// 将返回的输入流转换成指定编码的字符串
				result = changeInputStream(urlConnection.getInputStream(), "utf-8");
			} else {
				
				  System.out.println(responseCode); System.out.println(s);
				 
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 将返回结果在控制台输出
		System.out.println(result);
	}
	/**
	 * 将一个输入流转换成指定编码的字符串
	 * @param inputStream
	 * @param encode
	 * @return
	 */
	private static String changeInputStream(InputStream inputStream, String encode) {
		String result = "";
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		if(inputStream != null){
			try {
				while((len = inputStream.read(data)) != -1){
					outStream.write(data,0,len);
				}
				result = new String (outStream.toByteArray(),encode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
} 
