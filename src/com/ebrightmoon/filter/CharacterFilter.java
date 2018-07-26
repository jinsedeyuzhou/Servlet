package com.ebrightmoon.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebrightmoon.servlet.CustomServletRequest;


/**
 * 当前Filter用于解决Web应用程序的全站乱码.
 *  * 请求中文乱码问题:
 *    * GET请求方式:
 *    * POST请求方式:
 *      request.setCharacterEncoding("utf-8");
 *  * 响应中文乱码问题:
 *    response.setContentType("text/html;charset=utf-8");
 */
public class CharacterFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		

		String method = request.getMethod();
		
		if("GET".equals(method)){
			request = new CustomServletRequest(request);
		}else if("POST".equals(method)){
			request.setCharacterEncoding("utf-8");
		}
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(request, response);
	}
	
	public void destroy() {
	}

}
