package com.ebrightmoon.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebrightmoon.servlet.CustomServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName="EncodingFilter",urlPatterns="/*")
public class EncodingFilter implements Filter {
	private final static Log logger = LogFactory.getLog(EncodingFilter.class);
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    	logger.info("EncodingFilter");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		

		String method = request.getMethod();
		
		if("GET".equals(method)){
			request = new CustomServletRequest(request);
		}else if("POST".equals(method)){
			request.setCharacterEncoding("utf-8");
		}
		logger.info("doFilter");
		response.setContentType("text/html;charset=utf-8");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.error("init");
	}

}
