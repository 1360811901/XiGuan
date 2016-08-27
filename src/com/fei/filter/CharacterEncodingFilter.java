package com.fei.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 设置进出站的编码格式
 */
public class CharacterEncodingFilter implements Filter {

	private String characterEncoding; // 编码方式，配置在web.xml 中
	private boolean enabled;          // 是否启用该Filter,配置在web.xml 中
	
    public CharacterEncodingFilter() {
    }

	
	public void destroy() {
		characterEncoding = null;      //销毁时清空资源
	}

	/**
	 * 设置编码格式
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(enabled || characterEncoding != null){
			//设置request 编码
			request.setCharacterEncoding(characterEncoding);
			//Utils.requestPrint(request, response);
			// 设置response 编码
			response.setCharacterEncoding(characterEncoding);
		}
		
		// 输出请求的头部信息
		HttpServletRequest req = (HttpServletRequest)request; // 将ServletRequest 强转成 HttpServletRequest
		@SuppressWarnings("unchecked")
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String headerName = e.nextElement();
			System.out.println(headerName+" : "+req.getHeader(headerName));//获取http发送来的消息头
		}
		
		// 输出请求体信息
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = request.getParameterMap();  
		String queryString = ""; 
		if(params.size() != 0){
		        for (String key : params.keySet()) {  
		            String[] values = params.get(key);  
		            for (int i = 0; i < values.length; i++) {  
		                String value = values[i];  
		                queryString += key + "=" + value + "&";  
		            }  
		        }  
		        // 去掉最后一个& 字符
		        queryString = queryString.substring(0, queryString.length() - 1);  
		}
		System.out.println("requestParams@" + queryString);
		
		chain.doFilter(request, response);
	}

	/**
	 * 初始化时加载参数
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 编码方式
		characterEncoding = fConfig.getInitParameter("characterEncoding");
		// 启用
		enabled = "true".equalsIgnoreCase(fConfig.getInitParameter("enabled").trim());
	}

}
