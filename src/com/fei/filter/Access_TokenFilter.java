package com.fei.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import com.fei.redis.RedisC;


public class Access_TokenFilter implements Filter {
	private String identity;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String access_token = request.getParameter(identity);
       
		if("null".equals(access_token) | "".equals(access_token) | null == access_token){
			out.append("{\"code\":601,\"causeBy\":\"params key is not correct>>>>}");  //参数值缺失
		}else{
			// 判断token 的有效性
			RedisC redis = new RedisC();
			//String token = Utils.getFromBase64(manageTokenValue);
			boolean b = redis.exitToken(access_token);
			if(b){
				// access_token is validate
				chain.doFilter(request, response);
			}else{
				// access_token is invalid
				out.append("{\"code\":602,\"causeBy\":\"params access_token is not valid , please login in>>>>}");
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// 这还是两种方式
		identity = config.getServletContext().getInitParameter("identity");
	}

}
