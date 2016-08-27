package com.fei.logic;

import com.fei.tools.FinalString;

import io.rong.models.Message;

public class AddFriendMessage extends Message{
	
	private String sourceUserId = "";
	private String targetUserId = "";
	private String message = "Hello";
	private String extra = "";
	protected transient String type = FinalString.CONTACT_MESSAGE;
	
	public String getType() {
		return type;
	}
	
	
    public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}



	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setExtra(String extra) {
		this.extra = extra;
	}



	//	"Request", "AcceptResponse", "RejectResponse"
	public String toString() {
		return "{\"operation\":\"Request\",\"sourceUserId\":\"" + sourceUserId + "\",\"targetUserId\":\"" + targetUserId +"\",\"message\":\"" + message +"\",\"extra\":\""+ extra +"\"}";
	}

}
