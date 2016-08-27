package com.fei.tools;

public class FinalString {
	//rongyun_message
	public static final String CONTENT_MESSAGE = "{\"content\":\"";
	public static final String 	SS = "你们已经是好友了";
	public static final String 	S = "已经是你的好友，你们可以开始聊天了";
	public static final String SSS = "{\"name\":\"deleteContact\",\"data\":\"{\"sourceId\":\"";
	public static final String SSS_WEI = "\"}\"}";
	public static final String PASSWORD_DEAULT = "s666666";
	
	public static final String USERNAME = "userId";
	public static final String PASSWORD = "passWord";
	public static final String PHONENUMBER = "phoneNumber";
	public static final String MOBLIECODE = "mobileCode";
	public static final String PASSWORD_SALT = "jindongfei$";//加在密码前面
	public static final String CONTACT = "contact";
	public static final String CONTACT_MESSAGE = "RC:ContactNtf"; //融云联系人消息
	public static final String SERVER_USERID = "18253597846"; //服务器userID
	public static final String SOURCEUSER = "sourceUserId";
	public static final String TARGETUSER = "targetUserId";
	public static final String MESSAGE = "message";
	public static final String SUMMARY = "summary";
	public static final String GROUPNAME = "groupName";
	
	public static final String HEADPORTRAITURL = "headPortraitUrl";
	public static final String NICKNAME = "nickName";
	public static final String WEI = "\"}";
	public static final String TOU = "{\"code\":\"200\",\"";
	public static final String ZHONG = "\":\"";
	public static final String GROUPID = "groupId";
	public static final String J = "j";
	public static final String PATTERN_ARBITRARILYNUMBER = "^[0-9]*$";
	public static final String KEY = "key";
	public static final String IMG = "img\\";
	public static final String MAPKEY = "userName,dynamicsContent,longitude,latitude,province,city,uType,destination,beginTime,overTime";
	public static final String FILETYPE	= "image";
	public static final String DYNAMICCONTENT = "dynamicsContent";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String UTYPE = "uType";
	public static final String DESTINATION = "destination";
	public static final String BEGINTIME = "beginTime";
	public static final String OVERTIME = "overTime";
	public static final String URL = "url";
	public static final String DYNAMICID = "dynamicId";
	public static final String FILENAME = "filename";
	public static final String SIZE = "size";
	public static final String COMMENTCONTENT = "commentContent";
	public static final String COMMENT_PARAMS_STRING = "access_token@userName@dynamicId@commentContent";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String THIRDPARTYLOGIN_PARAMS_STRING = "access_token@userId@headPortraitUrl@nickName";
	
	public static final String EXCEPTION_MSG = "{\"code\":\"600\",\"causeby\":\"";
	//异常字符串
	public static final String GETUSERINFORMATION_ERROR = "{\"code\":\"660\",\"causeby\":\"get userinformation is error\"}";
	//参数错误
	public static final String PARAMS_ERROR = "{\"code\":\"768\",\"causeby\":\"params error\"}";
	// 成功返回
	public static final String CODE_SUC = "{\"code\":200,\"causeby\":\"success\"}";
	// 失败返回
	public static final String CODE_FAI = "{\"code\":\"600\",\"causeby\":\"fail\"}";
	// 系统错误
	public static final String SYSTEM_ERROR = "{\"code\":\"605\",\"causeby\":\"system logic is wrong\"}";
	// 参数缺失
	public static final String ARGUMENTS_ERROR = "{\"code\":\"601\",\"causeby\":\"arguments missing\"}";
	// 参数格式错误
	public static final String ARGUMENTS_FORMATERROR = "{\"code\":\"602\",\"causeby\":\"arguments format error\"}";
	// 用户不存在
	public static final String USER_NOEXIT = "{\"code\":\"603\",\"causeby\":\"user is not register\"}";
	//密码错误
	public static final String PASSWORD_ERROR = "{\"code\":\"604\",\"causeby\":\"passWord is mistake\"}";
	//系统原因登录失败，登录失败
	public static final String LOGIN_FAIL = "{\"code\":\"606\",\"causeby\":\"login model is error\"}";
	// 短信发送失败
	public static final String SENDCODE_FAIL = "{\"code\":\"610\",\"causeby\":\"send sms is fail\"}";
	//短信模块错误，发送失败
	public static final String SENDCODE_MODEL = "{\"code\":\"620\",\"causeby\":\"send sms model is fail\"}";
	//保存用户失败，用户已存在
	public static final String SAVEUSER_ERROR = "{\"code\":\"630\",\"causeby\":\"user has been exit\"}";
	//保存用户失败，模块出现问题
	public static final String SAVEUSERMODEL_ERROR = "{\"code\":\"631\",\"causeby\":\"save user model is error\"}";
	//black_passWord is error
	public static final String BASE64_ISERRORFORMAT = "{\"code\":\"632\",\"causeby\":\"base64 format is mistake\"}";
	//验证验证码出错，服务器端找不到此号，请从新获取验证码
	public static final String MOBILECODESERVER_NONE = "{\"code\":\"640\",\"causeby\":\"server is not exit this code,please send sms again\"}";
	//验证码错误
	public static final String MOBILECODE_MISTAKE = "{\"code\":\"641\",\"causeby\":\"mobile code is mistake\"}";
	//验证码模块出现错误
	public static final String MOBILECODEMODEL_ERROR = "{\"code\":\"645\",\"causeby\":\"mobile code model is error\"}";
	//对密码加密出错
	public static final String PASSWORDBLACK_ERROR = "{\"code\":\"655\",\"causeby\":\"encode password is error\"}";
	//获取rongyun token 失败
	public static final String GETRONGYUN_MISTAKE = "{\"code\":\"661\",\"causeby\":\"get rongyun token is fail\"}";
	//rongyun is error
	public static final String RONGYUN_ERROR = "{\"code\":\"662\",\"causeby\":\"rongyun error\"}";
	//找不到用户，请注册
	public static final String USERNOTEXIT = "{\"code\":\"670\",\"causeby\":\"user is not exit ,please register\"}";
	//添加联系人失败
	public static final String CONTACTSAVE = "{\"code\":\"680\",\"causeby\":\"you are friends\"}";
	//用户没好友
	public static final String NOCONTACTS = "{\"code\":\"690\",\"causeby\":\"this username is no contacts\"}";
	// 系统发送向用户发送好友请求信息
	public static final String REQUESTFRIENDMESSAGE_ERROR = "{\"code\":\"700\",\"causeby\":\"send friend message model is error\"}";
	// 发送好友请求失败
	public static final String SENDFRIEND_FAIL = "{\"code\":701,\"causeby\":\"send friend message is fail\"}";
	// 创建群模块error
	public static final String CREATEGROUP_MODELERROR = "{\"code\":\"710\",\"causeby\":\"create group model is error\"}";
	// 重置密码模块出现问题
	public static final String RESETPASSWORD_MODELERROR = "{\"code\":\"720\",\"causeby\":\"reset password model is error\"}";
	// 加入群模块出现问题
	public static final String ADDGROUP_MODELERROR = "{\"code\":\"730\",\"causeby\":\"add group model is error\"}";
	// 群不存在
	public static final String GROUP_NOTEXIT = "{\"code\":\"731\",\"causeby\":\"group is not exit\"}";
	// 已在群中
	public static final String GROUP_EXIT = "{\"code\":\"732\",\"causeby\":\"member has joined group\"}";
	//获取群信息模块error
	public static final String GETGROUPINFORMATION_ERROR = "{\"code\":\"740\",\"causeby\":\"get group information error\"}";
	//当前用户没有创建群组
	public static final String CURRENTCUSTOMER_NOTGROUP = "{\"code\":\"740\",\"causeby\":\"get group information error\"}";
	//退出群模块error
	public static final String QUITGROUP_MODELERROR = "{\"code\":\"750\",\"causeby\":\"quit group error\"}";
	//用户不在群中
	public static final String USERNOTINGROUP = "{\"code\":\"751\",\"causeby\":\"user not in group\"}";
	//删除联系人模块error
	public static final String DELETECONTACT_MODELERROR = "{\"code\":\"761\",\"causeby\":\"delete contacts is error\"}";
	//保存联系人模块error
	public static final String SAVECONTACT_MODELERROR = "{\"code\":\"762\",\"causeby\":\"save contacts is error\"}";
	//搜索用户
	public static final String KEYWORDS_MISTAKE = "{\"code\":\"763\",\"causeby\":\"key words is mistake\"}";
	//搜索model error
	public static final String SEARCH_MODELERROR = "{\"code\":\"764\",\"causeby\":\"search users model is error\"}";
	//上传用户动态 model error
	public static final String 	UPLOADMESSAGE_MODELERROR = "{\"code\":\"765\",\"causeby\":\"upload dynamical model is error\"}";
	//点赞模块 is error
	public static final String 	CLICKONLIKE_MODELERROR = "{\"code\":\"766\",\"causeby\":\"click on like model is error\"}";
	//评论模块 is error
	public static final String 	COMMENT_MODELERROR = "{\"code\":\"767\",\"causeby\":\"comment dynamic model is error\"}";
	//附近的人模块 is error
	public static final String 	NEARBYPEOPLE_MODELERROR = "{\"code\":\"768\",\"causeby\":\"nearby people model is error\"}";
	//第三发登录模块 is error
	public static final String 	THIRDPARTYLOGIN_MODELERROR = "{\"code\":\"769\",\"causeby\":\"third-party login model is error\"}";
}
