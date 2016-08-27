package com.fei.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Pattern;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fei.garbage.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Util {
	public static final JSONObject jResult_Suc = new JSONObject().accumulate("code", "200");
	public static final JSONObject jResult_Fai = new JSONObject().accumulate("code", "600");
	
	/**
	 * ����manageToken
	 * @param sessionId
	 * @return
	 */
	public static ManageToken createManageToken(String sessionId){
		UUID uid = UUID.randomUUID();
		ManageToken manageToken = new ManageToken();
		manageToken.setManageTokenValue(uid.toString());
		return manageToken;
	}
	/**
	 * �ж�manageToken �Ƿ���Ч
	 * @param manageToken
	 * @return
	 */
	public static boolean isValid(ManageToken manageToken){
		boolean flag = false;
		try{
			UUID uid = UUID.fromString(manageToken.getManageTokenValue());
			flag = true;
		}catch(IllegalArgumentException e){
			System.out.println("manageToken exception");
		}
		return flag;
	}
	
	/**
	 * �����Ʒ���������Token
	 * @param url ��������URL
	 * @param param �������
	 * @return ����Զ����Դ����Ӧ���
	 */
	public static String getRongYunToken(String url,String param){
		//ʹ��httpRequest �෢������
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL readUrl = new URL(url);
			//�򿪺�URL ֮�������
			URLConnection conn = readUrl.openConnection();
			//����ͨ�õ���������
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("connection", "keep-Alive");
			conn.setRequestProperty("App-key", "k51hidwq1uw1b");
			conn.setRequestProperty("Nonce", "88");
			String stam = "" + System.currentTimeMillis();
			conn.setRequestProperty("Timestamp", stam);
			String s = "k51hidwq1uw1b" + "88" + stam;
			String value = Util.countSHA1(s);
			conn.setRequestProperty("Signature", value);
			conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1)");
			//����post ������뷢����������
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//��ȡURLConnection �����Ӧ�������
			out = new PrintWriter(conn.getOutputStream());
			//�����������
			out.print(param);
			//flush ������Ļ���
			out.flush();
			//����BufferedReader ���������ȡURL ����Ӧ
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = in.readLine()) !=null){
				result +=line;
			}
		} catch (Exception e) {
			System.out.println("���� post ��������쳣�� +" + e);
			e.printStackTrace();
		}finally{
			try{
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		// ʹ��finally�����ر��������������
		return result;
	}
	
	public static String countSHA1(String s) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(s.getBytes());
		StringBuffer buf = new StringBuffer();
		byte[] bits = md.digest();
		for(int i = 0;i <bits.length;i++){
			int a = bits[i];
			if(a<0)
				a+=256;
			if(a<16)
				buf.append("0");
			buf.append(Integer.toHexString(a));
		}
		return buf.toString();
	}
	
	//����Hibernate sessionFactory ʵ��
	
	public static SessionFactory getSessionFactory(String url){
		//����Ĭ��λ�õ� configuration ������Ϣ���� configuration ʵ��
		// Ĭ�ϵ�λ������src Ŀ¼��
		Configuration config = new Configuration();
		//����User ��ӳ���ϵ�ļ�
		config.addResource(url);
		//����sessionFactory ʵ��
		SessionFactory sessionFactory = config.buildSessionFactory();
		return sessionFactory;
	}
	
	public static boolean validatePassWord(String passWord){
		String pattern = "^[a-zA-Z]\\w{5,8}$";
		boolean match = Pattern.matches(pattern, passWord);
		System.out.println(match);
		return match;
	}
	

}
