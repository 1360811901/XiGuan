package com.fei.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fei.tools.Utils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Test {
	public static void main(String[] args) throws IOException{
		/*JSONObject js = JSONObject.fromObject("{'erro':'��Ȩ��'}");
		//System.out.println(js);
		System.out.println(com.fei.util.Util.jResult_Suc.toString());
		System.out.println(com.fei.tools.FinalString.CODE_SUC);
		String url = Test.class.getResource("").getPath();
		URL path = Thread.currentThread().getContextClassLoader().getResource("");*/
		//System.out.println(path.getPath());
		//System.out.println(System.getProperty("java.class.path"));
		//HttpRuquest.setGetRequest("http://127.0.0.1:8080/feiServer/jmanage/LoginServlet?manageToken={manageTokenValue:'aaaaaaaaaaj123555555'}", "manageToken=aaaaaaaaaaj123555555");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/LoginServlet", "manageToken={manageTokenValue:'aaaaaaaaaaj123555555'}&params={userName:'18288888888',passWord:'a123456'}");
		//HttpRuquest.setGetRequest("http://127.0.0.1:8080/feiServer/CreateManageTokenServlet","");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/register", "manageToken={manageTokenValue:'aaaaaaaaaaj123555555'}&params={phoneNumber:'18253597846'}");
		//HttpRuquest.setGetRequest("http://127.0.0.1:8080/feiServer/jmanage/LoginServlet","");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/register", "manageToken=14E3276C203957C0316066D41E899EADj1465379007394&phoneNumber=18253597846");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/SaveUser", "passWord=a10072008&phoneNumber=18637953703&manageToken=327FBC9D3E781667AE3D8589189F9EF0j1465783754701");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/RongYunToken", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&phoneNumber=18288888888");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/AddFriendServlet", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&phoneNumber=18288888888&friendU=18253597846");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/TestServlet", "manageToken=14E3276C203957C0316066D41E899EADj1465379007394");
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/Virication", "manageToken={manageTokenValue:'aaaaaaaaaaj123555555'}&code=''&sessionId=");
		//测试发送验证码
		//1.缺少参数
		//HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/register", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef");  //ok
		//2.参数格式错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/register", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&phoneNumber=182535978460"); // ok
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/register", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&phoneNumber=1825359784f"); //ok
		//3.参数正常
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/register", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&phoneNumber=18253597846"); //ok 短信发送成功428542
		
		// 验证验证码
		//1.缺少参数
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/Vification", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&mobileCode="); //ok
		//2.参数格式错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/Vification", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&mobileCode=&phoneNumber=18253597846"); //ok
		//3.参数正确，错误电话号码
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/Vification", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&mobileCode=428542&phoneNumber=18253597847"); //ok
		//4.正确形式
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/Vification", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&mobileCode=428542&phoneNumber=18253597846"); //ok
		
		//保存用户
		//1.缺少参数
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/SaveUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=&pass="); //ok
		//2.参数格式错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/SaveUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=1234567"); //error
		// 验证加密密码的时候没有改变
		//重新开始
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/jmanage/SaveUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=1234567"); //ok
		//base64 1234567
		String s = Utils.getBase64("jindongfei$a123456");
		System.out.println(s);
		String s2 = Utils.getFromBase64(s);
		System.out.println(s2);
		//3. 格式错误的密码正确base64编码
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/SaveUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=MTIzNDU2Nw=="); //返回base64错误，其实是数组下标越界，被它try出来了
		//4. 加盐之后
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/SaveUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=amluZG9uZ2ZlaSRhMTIzNDU2Nw==");  //error 没有判断盐值
		//已经修改
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/SaveUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=amluZG9uZ2ZlaSRhMTIzNDU2Nw=="); //error 表名没改
		//已经修改
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/jmanage/SaveUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597848&passWord=amluZG9uZ2ZlaSRhMTIzNDU2Nw=="); //ok 数据库中已经有值，但是省份的默认值不对
		//已经改正
		
		//测试登录
		//1.缺少参数
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/LoginServlet", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWd=1234567"); //ok
		//2.加密错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/LoginServlet", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=1234567"); //ok
		//3.参数格式错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/LoginServlet", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=amluZG9uZ2ZlaSQxMjM0NTY3"); //ok
		//4.正确
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/login/userLogin", "userName=18253597846&passWord=amluZG9uZ2ZlaSRhMTAwNzIwMDg="); //ok
		
		//MTgyNTM1OTc4NDZKMTQ3MDEyMzM3MjA1MzI=
		// 获取rongyun token
		//1.参数错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/chitchat/getToken_rongyun", "manageToken=MTgyNTM1OTc4NDZKMTQ3MDEyMzM3MjA1MzI=&userName=18253597846"); //ok
		//2.各种正确
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/RongYunToken", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18637953703"); //ok
		
		// 添加好友
		//1. 缺少参数
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/AddFriendServlet", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846"); //ok
		//2. 参数格式错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/AddFriendServlet", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=a8253597846&contact=18253597846"); //ok
		//3. 参数各种正确
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/AddFriendServlet", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&contact=18253597848"); //perfect 完美
		// 18253597848 is not register
		//4. 正确
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/chitchat/addFriends", "manageToken=MTgyNTM1OTc4NDZKMTQ3MDEyMzM3MjA1MzI=&userName=18253597847&contact=18253597846"); //ok
		
		// 获取好友信息
		//1. 参数错误
	//	HttpRuquest.setGetRequest("http://127.0.0.1:8080/feiServer/jmanage/GetFriendAll?manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=1825359784", ""); //ok
		//2. 缺少参数
	//	HttpRuquest.setGetRequest("http://127.0.0.1:8080/feiServer/jmanage/GetFriendAll?manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&username=1825359784", ""); //ok
		//3. 正确
	//	HttpRuquest.setGetRequest("http://127.0.0.1:8080/feiServer/jmanage/GetFriendAll?manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846", "");  // hibernate 对于多表查询还有很多问题需要解决
		
		//忘记密码
		//1. 缺少参数
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/jmanage/GetPassW", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846"); //ok
		// 2. 正常
	//	HttpRuquest.setPostRequest("http://http://ec2-54-201-87-250.us-west-2.compute.amazonaws.com:8088/feiServer/jmanage/GetPassW", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846"); //ok
		
		// 重置密码
		
	//	HttpRuquest.setGetRequest("http://127.0.0.1:8080/feiServer/jmanage/ResetPassWord?manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef", ""); 
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/ResetPassWord", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=amluZG9uZ2ZlaSRhMTQ1NjY3");
		// 创建群
		//1.参数错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/CreateGroup", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&passWord=amluZG9uZ2ZlaSRhMTQ1NjY3"); //ok
		//2.参数正确
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/CreateGroup", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&summary=快加群2&groupName=初代群2"); //ok
		
		// 加入群
		//1. 参数错误,格式错误
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/AddGroup", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&groupId=amluZG9uZ2ZlaSRhMTQ1NjY3"); //ok
		//2. 正确情况
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/AddGroup", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846&groupId=18253597846j1467598356377"); //0k
		
		//通过userName 获取群信息
		//1. 
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8080/feiServer/jmanage/GetGroupInformation", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&userName=18253597846"); //ok
		
		//发送好友请求
		//1.
//		HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/jmanage/SendFriendRequire", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&message=你好，我想加你的好友&targetUser=18637953703&sourceUser=15589543227");
		
		// 搜索好友
		//1.
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/jmanage/SearchUser", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&key=飞天翔");
		// 点赞
		//1.
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/jmanage/ClickOnLike", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&dynamicId=18253597846j1469093322172");
		
		//评论18253597846j1469093322172
	//	HttpRuquest.setPostRequest("http://127.0.0.1:8088/feiServer/jmanage/DynamicComment", "manageToken=7c4eadbc-8fb7-4a67-a30a-ee58a67014ef&dynamicId=18253597846j1469093322172&userName=18253597846&commentContent=很好，很厉害&userName=18253597848");
	}
	
}
