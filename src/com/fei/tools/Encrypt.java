package com.fei.tools;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
	
	private final static String FSHA1 = "SHA-1";
	
	private final static String FMD5 = "MD5";
	
	private final static String FAES = "AES";
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
	/**
	 * 将一个字节转化成十六进制形式的字符串
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	/**
	 * 将一个字节数组转化成 十六进制字符串
	 * @param b
	 * @return
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	/**
	 * 进行SHA-1 计算
	 * @param plainText
	 * @return String
	 */
	public static String SHA1(String plainText){
		String result = null;
		try {
			
			MessageDigest digest = java.security.MessageDigest.getInstance(FSHA1);
			digest.update(plainText.getBytes("utf-8"));
			byte messageDigest[] = digest.digest();
			//将返回的字节数组转化成16 进制数
			result = byteArrayToHexString(messageDigest);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("product SHA-1 abstract fail!!!!");
		}
		return result;
	}
	/**
	 * 进行MD5 计算
	 * @param origin
	 * @return
	 */
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance(FMD5);
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("product MD5 abstract fail!!!!");
		}
		return resultString;
	}
	/**
	 * 将字符串进行AES 加密
	 * @param plaintText
	 * @param key
	 * @return
	 */
	public static byte[] AES(String plaintText,String key){
		byte[] result = null;
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(FAES);
			SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes("utf-8"));
			kgen.init(128, random);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec keys = new SecretKeySpec(enCodeFormat, FAES);
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = plaintText.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, keys);// 初始化
			result = cipher.doFinal(byteContent);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | 
				UnsupportedEncodingException | InvalidKeyException | 
				IllegalBlockSizeException 
				| BadPaddingException e) {
			e.printStackTrace();
			System.out.println("product AES fail");
		}
		return result;
	}
	
	/**
	 * 将AES 加密的密文解密
	 * @param blackText
	 * @param key
	 * @return
	 */
	public static String decAES(byte[] blackText,String key){
		String plaintText = null;
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(FAES);
			SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes("utf-8"));
			kgen.init(128, random);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec keys = new SecretKeySpec(enCodeFormat, FAES);
			Cipher cipher = Cipher.getInstance(FAES);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, keys);// 初始化
			byte[] result = cipher.doFinal(blackText);
			plaintText = byteArrayToHexString(result);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("des AES fail");
		}
		return plaintText;
		
	}
		

}
