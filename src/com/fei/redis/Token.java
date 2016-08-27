package com.fei.redis;

import java.util.HashMap;
import java.util.Map;

public class Token {
	
	private static int i = 1;
	private static long mills = System.currentTimeMillis();
	private static final Token token = new Token();
	
	private Token(){}
	
	public static Token getTokenInstance(){
		return token;
	}
	
	public String createToken(String userId){
		String token = userId + "J" + mills +  i;
		i++;
		return token;
	}
	
	public Map<String,String> createHash(String userId,String id){
		Map<String,String> hash = new HashMap<String,String>();
		hash.put("userId", userId);
		hash.put("id", id);
		hash.put("lgit", String.valueOf(mills));
		return hash;
	}

}
