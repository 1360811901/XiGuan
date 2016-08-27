package com.fei.rong;

import java.util.ArrayList;
import java.util.List;

import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;

public class Rong extends ApiHttpClient {
	
	private static final String APPKEY = "0vnjpoadnslfz";
	private static final String APPSECRET = "xjQfDnnxexn8";
	private static final FormatType FORMAT = FormatType.json;
	private static final String fromUserId = "18253597846";
	private static final String pushContent = "好友提示";
	private static final String pushData = "friend";
	
	
	//向双方发送系统通知，你们已经是好友了
	public static boolean sendSystemNotify(List<String> toUserIds) throws Exception{
		boolean flag = false;
		SystemMessage sm = new SystemMessage();
		sm.contact = toUserIds.get(0) + "," + toUserIds.get(1);
		SdkHttpResult rs = publishSystemMessage(APPKEY, APPSECRET, fromUserId, toUserIds, sm, pushContent, pushData, FORMAT);
		if(200 == rs.getHttpCode())
			flag = true;
		return flag;
	}
	
	//发送单聊消息
	public static boolean sendPrivateMessage(String fromUserId,String toUserId) throws Exception{
		boolean flag = false;
		PrivateMessage pm = new PrivateMessage();
		pm.contact = fromUserId;
		List<String> toUserIds = new ArrayList<String>();
		toUserIds.add(toUserId);
		SdkHttpResult rs = publishMessage(APPKEY, APPSECRET, fromUserId, toUserIds, pm, FORMAT);
		if(200 == rs.getHttpCode())
			flag = true;
		return flag;
	}
	
	//发送单聊私信消息（通知前端更新好友列表）
	public static boolean sendPrivateOrderMessage(String userName,String toUserId) throws Exception{
		boolean flag = false;
		OrderMessage om = new OrderMessage();
		om.contact = userName;
		List<String> toUserIds = new ArrayList<String>();
		toUserIds.add(toUserId);
		SdkHttpResult rs = publishMessage(APPKEY, APPSECRET, fromUserId, toUserIds, om, FORMAT);
		if(200 == rs.getHttpCode())
			flag = true;
		return flag;
	}

}
