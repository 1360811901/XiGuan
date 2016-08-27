package com.fei.rong;

import com.fei.tools.FinalString;

import io.rong.models.Message;

public class SystemMessage extends Message {
	
	protected transient String type = "RC:TxtMsg" ;
	
	public String contact;
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return FinalString.CONTENT_MESSAGE + contact + FinalString.SS + FinalString.WEI;
	}

}
