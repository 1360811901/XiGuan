package com.fei.design2;

import javax.servlet.http.HttpServletRequest;

public class Factory {

	@SuppressWarnings("unchecked")
	public <T extends Params> T createFactory(String s, HttpServletRequest request, Class<T> c) throws Exception {
		Params params = null;
		// 生成一个对象
		params = (T) Class.forName(c.getName()).newInstance();
		// 创建 ps 对象
		ParamsString ps = new ParamsString();
		ps.setNeedParams(s);
		// 创建 sp 对象
		ServletParams sp = new ServletParams();
		sp.setParms(request);
		// 调用对象创建工厂
		ParamsFactory paramsFactory = new ParamsFactory();
		params = paramsFactory.createParam(ps, sp, c);
		return (T) params;

	}

}
