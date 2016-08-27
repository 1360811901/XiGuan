package com.fei.rong;

import com.fei.tools.FinalString;

import io.rong.models.Message;

public class OrderMessage extends Message {

protected transient String type = "RC:CmdMsg";
	
	public String contact;

	public String getType() {
		return type;
	}
	
	//{"name":"AtPerson","data":"{\"sourceId\":\"9527\"}"}
	@Override
	public String toString() {
		return FinalString.SSS + contact + FinalString.SSS_WEI;
	}

}
