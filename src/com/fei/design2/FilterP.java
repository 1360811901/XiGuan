package com.fei.design2;

public interface FilterP {
	// 验证参数是否缺失
	public boolean isLose();

	// 验证格式是否正确
	public boolean isFormat();

	// 验证参数是否有效
	public boolean isValid();

	public boolean isOk();
}
