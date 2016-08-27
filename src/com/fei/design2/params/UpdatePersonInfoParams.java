package com.fei.design2.params;

import com.fei.design2.Params;

public class UpdatePersonInfoParams extends Params {
	private String fieldKey;
	private String fieldValue;

	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	@Override
	public boolean matchPrivateParams() {
		boolean flag = false;
		// key 的值是枚举类型的
		switch (this.fieldKey) {
		case "nickName":
			flag = true;
			break;
		case "sex":
			flag = true;
			break;
		case "age":
			flag = true;
			break;
		case "career":
			flag = true;
			break;
		case "email":
			flag = true;
			break;
		case "signature":
			flag = true;
			break;
		case "hometown":
			flag = true;
			break;
		case "constellation":
			flag = true;
			break;
		case "label":
			flag = true;
			break;
		case "education":
			flag = true;
			break;
		}
		if(flag&(!"".equals(this.fieldValue))){
			return true;
		}
		return false;
	}

}
