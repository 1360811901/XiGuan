package com.fei.garbage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fei.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Login {
	
	public String userName;
	public String passWord;
	
	public Login(String user,String passW){
		this.userName = user;
		this.passWord = passW;
	}
	
	//����¼���ݵ���Ч��
	/**
	 * ʹ��������ʽ�Զ�username���м�飬
	 * ֻ���password�ĳ����Ƿ���ȷ
	 * @return
	 */
	public boolean isForeDataVaild(){
		boolean flag = false;
		// �绰�����������ʽ
		String pattern = "^[1][358][0-9]{9}$";
		boolean match = Pattern.matches(pattern, userName);
		System.out.println("match" + match);
		// ƥ��6λ����λ��������ʽ
		String pat = "^[a-zA-Z]\\w{5,8}$";
		boolean mat = Pattern.matches(pat, passWord);
		System.out.println("mat" + mat);
		if(match && mat)
			flag = true;
		return flag;
		
	}
	
	//��ѯ���ݿ����û��������Ƿ���ȷ
	public String isTrue(){
		System.out.println("isTrue");
		String flag = "";
		SessionFactory sessionFactory = Util.getSessionFactory("com/fei/dao/User.hbm.xml");
		Session session = sessionFactory.openSession();
		Transaction ts = null;
		String sql = " from User where userName = " +"'"+ userName +"'";
		ts = session.beginTransaction();
		Query query = session.createQuery(sql);
		ts.commit();
		//session.close();
		List<User> list = query.list();
		if(list.size()>1){
			//��ȡ��ǰ����·�����ڵ�ǰ��·���ĸ�Ŀ¼
			String path = Login.class.getResource("").getPath();
			//���ļ�����������д������
			 try {
				FileWriter out = new FileWriter(path + "loginlog.txt", true);
				// ���ļ���д������
				out.write("error:" + userName);
				out.write("\\r\\n");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}else if(list.size()==0){
			flag = "Can not find the user";
		}else if(list.size()==1){
			//JSONObject jo = list.get(0);
			//JSONArray ja = JSONArray.fromObject(list);			   
			User use = list.get(0);
			String passWordm = use.getPassWord();
			System.out.println(passWordm);
			System.out.println(passWord);
			if(passWordm.equals(passWord)){
				flag = "Correct password";
			}else{
				flag = "Error password";
			}
		}
		session.close();
		return flag;
	}
}
