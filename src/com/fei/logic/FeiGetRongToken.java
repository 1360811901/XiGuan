package com.fei.logic;

import java.util.ArrayList;
import java.util.List;

import com.fei.Entity.GroupBaseInformation;
import com.fei.Entity.UserBaseInformation;
import com.fei.dao.GroupOption;
import com.fei.feithrows.UserBaseInformationException;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.Message;
import io.rong.models.SdkHttpResult;
import net.sf.json.JSONObject;

public class FeiGetRongToken {
	private static final String APPKEY = "0vnjpoadnslfz";
	private static final String APPSECRET = "xjQfDnnxexn8";
	private static final FormatType FORMAT = FormatType.json;
	private static boolean getToken = false;
	
	
	public static boolean isGetToken() {
		return getToken;
	}

	/**
	 * 获取rongyunToken
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public static String getRongToken(String userName) throws Exception{
		String token = null;
		String nickName = null;
		String portraitURL = null;
		List<UserBaseInformation> users = Utils.getUserBaseInformation(userName);
		if(users.size() == 1){
			UserBaseInformation use = users.get(0);
			nickName = use.getNickName();
			portraitURL = use.getHeadPortraitURL();
		}else{
			throw new UserBaseInformationException(FinalString.GETUSERINFORMATION_ERROR);
		}
		SdkHttpResult rs = ApiHttpClient.getToken(APPKEY, APPSECRET, userName, nickName, portraitURL, FORMAT);
		if(200 == rs.getHttpCode()){
			System.out.println(JSONObject.fromObject(rs.toString()));
			token = JSONObject.fromObject(JSONObject.fromObject(rs.toString()).get("result")).getString("token");
			getToken = true;
		}else{
			token = FinalString.GETRONGYUN_MISTAKE;
		}
		return token;
	}
	
	/**
	 * 发送好友系统消息
	 * @param fromUserId
	 * @param toUserIds
	 * @param msg
	 * @param pushContent
	 * @param pushData
	 * @return
	 * @throws Exception 
	 */
	public static String sendFriendSystemMessage(List<String> toUserIds,Message msg, String pushContent, String pushData) throws Exception{
		String result = "";
		//每次都查询数据库看两人是否注册太号资源，默认两个user是true
		SdkHttpResult rs = ApiHttpClient.publishSystemMessage(APPKEY, APPSECRET, FinalString.SERVER_USERID, toUserIds, msg, pushContent, pushData, FORMAT);
		if(200 == rs.getHttpCode()){
			result = FinalString.CODE_SUC;
		}
		return result;
	}
	/** 
	 * 保存群信息
	 * @param userName
	 * @param summary
	 * @param name
	 * @return
	 */
	public static String createGroup(String userName,String summary,String name){
		String result = "";
		// 通知融云 创建群
		String groupId = userName + FinalString.J +System.currentTimeMillis();
		List<String> users = new ArrayList<String>();
		users.add(userName);
		try {
			SdkHttpResult rs = ApiHttpClient.createGroup(APPKEY, APPSECRET, users, groupId, name, FORMAT);
			GroupBaseInformation gi = new GroupBaseInformation();
			gi.setGroupId(groupId);
			gi.setGroupOwn(userName);
			gi.setGroupName(name);
			gi.setGroupSummary(summary);
			if(200 == rs.getHttpCode()){
				// 将群信息保存到数据库中
				GroupOption.alertRecord(gi);
				result = groupId;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("融云创建群is error");
		}
		return result;
	}
	/**
	 * 加入群
	 * @param userName
	 * @param groupId
	 * @param groupName
	 * @throws Exception 
	 */
	public static boolean addGroup(String userName,String groupId,String groupName) throws Exception{
		boolean flag = false;
		SdkHttpResult rs = ApiHttpClient.joinGroup(APPKEY, APPSECRET,userName, groupId,groupName,FORMAT);
		if(200 == rs.getHttpCode())
			flag = true;
		
		return flag;
	}
	/**
	 * 退出群
	 * @param userName
	 * @param groupName
	 * @return
	 * @throws Exception 
	 */
	public static boolean quitGroup(String userName,String groupId) throws Exception{
		boolean flag = false;
		SdkHttpResult rs = ApiHttpClient.quitGroup(APPKEY, APPSECRET, userName, groupId, FORMAT);
		if(200 == rs.getHttpCode())
			flag = true;
		return flag;
	}

}
