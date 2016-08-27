    package com.fei.design2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fei.feithrows.ParamsException;

public class LoginParamsFactory {

	@SuppressWarnings("unchecked")
	public <T extends Params> T createLoginParam(String s, HttpServletRequest request, Class<T> cl) throws Exception {
		// 创建 ps 对象
		ParamsString ps = new ParamsString();
		ps.setNeedParams(s);
		// 创建 sp 对象
		ServletParams sp = new ServletParams();
		sp.setParms(request);
		// 定义一个参数
		// T params = null;
		Params loginParams = null;
		String[] str = ps.getNeedKeys();
		Map<String, String[]> slv = sp.getParms();

		try {
			loginParams = (T) Class.forName(cl.getName()).newInstance();
			// 判断 参数是否缺失
			SingletonTools singletonTools = SingletonTools.getSingleInstance();
			boolean a = singletonTools.matchKeys(str, slv);
			if (!a)
				throw new ParamsException("params key is not correct>>>>",601);
			// 组装loginParams
			Tools.assembleParams(cl, loginParams, slv);
			boolean b = loginParams.matchPrivateParams();
			if (!b)
				throw new ParamsException("params format is error>>>>",604);
		} catch (Exception e) {
			throw e;
		}
		return (T) loginParams;
	}
}
