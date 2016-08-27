package com.fei.tools;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fei.Entity.UserBaseInformation;
import com.fei.feithrows.UserBaseInformationException;
import com.fei.logic.FeiUserInfor;
import com.fei.logic.LoginFeiServer;

import net.sf.json.JSONArray;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Utils {
	private static Logger logger = Logger.getLogger(Utils.class);
	private static final String XML_MAP = "com/fei/dao/UserBaseInformation.hbm.xml";
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	/**
	 * 判断用户名的格式是否正确
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean judgeUserName(String userName) {

		String pattern = "^[1][358][0-9]{9}$";
		boolean match = Pattern.matches(pattern, userName);
		// 第三方账号
		if(true)
			match = true;
		return match;
	}

	/**
	 * 判断密码的格式是否正确
	 * 
	 * @param passWord
	 * @return
	 */
	public static boolean judgePassWord(String passWord) {
		String pattern = "^[a-zA-Z]\\w{5,8}$";
		boolean match = Pattern.matches(pattern, passWord);
		return match;
	}

	/**
	 * 根据xml 映射文件返回 hibernate session
	 * 
	 * @param xml_map
	 * @return
	 */
	public static Session getSession() {
		/*
		 * Configuration config = new Configuration(); config.configure();
		 * SessionFactory sessionFactory = config.buildSessionFactory();
		 */
		//return sessionFactory.openSession();
		// return HibernateUtil.currentSession();
		return HibernateClient.getSession();
	}

	/**
	 * 判断验证码格式是否正确
	 * 
	 * @param mobileCode
	 * @return
	 */
	public static boolean judgeMobileCode(String mobileCode) {
		String pattern = "^[0-9]{6}$";
		boolean match = Pattern.matches(pattern, mobileCode);
		return match;
	}

	/**
	 * 对字符串进行base64编码加密
	 * 
	 * @param str
	 * @param salt
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	public static String getBase64(String str) throws UnsupportedEncodingException {
		byte[] b = null;
		String s = null;
		b = str.getBytes("utf-8");
		if (b != null)
			s = new BASE64Encoder().encode(b);
		return s;
	}

	/**
	 * 对字符串进行base64 解密
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public static String getFromBase64(String s) throws IOException {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			b = decoder.decodeBuffer(s);
			result = new String(b, "utf-8");
		}
		return result;
	}

	/**
	 * 根据userName 查询数据库并返回相应的数据
	 * 
	 * @param userName
	 * @return
	 */
	public static List<UserBaseInformation> getUserBaseInformation(String userName) {
		List<UserBaseInformation> users = new ArrayList<UserBaseInformation>();
		Session session = com.fei.tools.Utils.getSession();
		String sql = " from UserBaseInformation where userName = " + "'" + userName + "'";
		Query query = session.createQuery(sql);
		List<UserBaseInformation> user = query.list();
		users.addAll(user);
		// 关闭session
		session.close();
		return users;
	}

	/**
	 * 更改用户密码
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public static boolean updataUser_baseinformationPassW(String userName, String passWord) {
		boolean flag = false;
		Session session = com.fei.tools.Utils.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"update UserBaseInformation  set passWord = '" + passWord + "' where userName = '" + userName + "'");
		query.executeUpdate();
		tx.commit();
		session.close();
		flag = true;
		return flag;
	}

	/**
	 * 更新用户的基本信息
	 * 
	 * @param userName
	 * @return boolean
	 */
	public static boolean updataUser_baseinformation(String userName, String token) {
		boolean flag = false;
		Session session = com.fei.tools.Utils.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"update UserBaseInformation  set rongtoken = '" + token + "' where userName = '" + userName + "'");
		query.executeUpdate();
		tx.commit();
		session.close();
		flag = true;
		return flag;
	}

	public static UserBaseInformation getBaseInformation(String userName) {
		UserBaseInformation useInfor = null;
		Session session = com.fei.tools.Utils.getSession();
		String sql = " from UserBaseInformation where userName = " + "'" + userName + "'";
		Query query = session.createQuery(sql);
		List<UserBaseInformation> user = query.list();
		if (user.size() == 1)
			useInfor = user.get(0);
		// 关闭session
		session.close();
		return useInfor;
	}

	public static boolean judgeSalt(String salt) {
		return FinalString.PASSWORD_SALT.equals(salt) ? true : false;
	}

	public static void requestPrint(ServletRequest request, ServletResponse response) {
		Map<String, String[]> params = request.getParameterMap();
		if (params.size() != 0) {
			String queryString = "";
			for (String key : params.keySet()) {
				String[] values = params.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					queryString += key + "=" + value + "&";
				}
			}
			// 去掉最后一个& 字符
			queryString = queryString.substring(0, queryString.length() - 1);
			System.out.println("queryString@" + queryString);
		}
	}

	// 判断groupId
	public static boolean judgeGroupId(String groupId) {
		boolean flag = false;
		String[] s = groupId.split(FinalString.J);
		if (judgeUserName(s[0]) & Pattern.matches(FinalString.PATTERN_ARBITRARILYNUMBER, s[1])) {
			flag = true;
		}
		return flag;
	}

	// user instance message
	public static String getInstanceInfo(List<UserBaseInformation> users) {
		String result = "";
		JSONArray ja = new JSONArray();
		if (users.size() != 0) {
			for (int i = 0; i < users.size(); i++) {
				UserBaseInformation user = users.get(i);
				System.out.println(user.getProvince());
				FeiUserInfor userInfo = new FeiUserInfor(user.getUserName(), user.getNickName(),
						user.getHeadPortraitURL());
				ja.add(userInfo);
			}
			result = ja.toString();
		}
		return result;
	}

	/**
	 * 判断map 的key 值
	 * 
	 * @return
	 */
	public static boolean judegMapKey(Map<String, String> formField, String arg) {
		boolean flag = false;
		Set<String> keys = formField.keySet();
		String[] args = arg.split(",");
		int count = 0;
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			Iterator<String> ia = keys.iterator();
			while (ia.hasNext()) {
				String a = ia.next();
				if (s.equals(a)) {
					count++;
					break;
				}
			}
		}
		if (count == args.length & args.length == keys.size())
			flag = true;
		return flag;
	}

	/**
	 * 判断map的值是否为null
	 * 
	 * @return
	 */
	public static boolean judgeMapValue(Map<String, String> formField) {
		boolean flag = false;
		boolean a = formField.containsValue(null);
		String s = formField.get(FinalString.USERNAME);
		boolean b = true;
		if ("".equals(s))
			b = false;
		if (b & !a)
			flag = true;
		return flag;
	}

	/**
	 * 判断文件的类型
	 * 
	 * @return
	 */
	public static boolean judgeFileType(List<FileItem> fitems, String Type) {
		boolean flag = true;
		for (int i = 0; i < fitems.size(); i++) {
			String ity = fitems.get(i).getContentType();
			String ty = ity.substring(0, ity.lastIndexOf("/"));
			if (!ty.equals(Type))
				flag = false;
		}
		return flag;
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
	public static HashSet<Integer> randomSet(int min, int max, int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (n > (max - min + 1) || max < min) {
			return set;
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
		return set;
	}
}
