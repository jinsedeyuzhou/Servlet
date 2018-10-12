package com.ebrightmoon.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebrightmoon.bean.ResponseResult;
import com.ebrightmoon.bean.UserInfo;
import com.ebrightmoon.utils.GsonUtil;
import com.ebrightmoon.utils.HttpServletRequestReplacedWrapper;
import com.ebrightmoon.utils.HttpUtils;
import com.ebrightmoon.utils.MD5;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 全局参数校验 Servlet Filter implementation class ParameterCalibrationFilter
 */
@WebFilter(filterName = "ParameterCalibrationFilter", urlPatterns = "/*")
public class ParameterCalibrationFilter implements Filter {
	private final static Log logger = LogFactory.getLog(EncodingFilter.class);
	/**
	 * Default constructor.
	 */
	public ParameterCalibrationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		logger.info("doFilter ParameterCalibrationFilter");
		ResponseResult responseResult = new ResponseResult<>();
		HttpServletRequestReplacedWrapper   requestWrapper = null;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		 if(request instanceof HttpServletRequest) {
			 requestWrapper = new HttpServletRequestReplacedWrapper((HttpServletRequest) request);  
         }  
		String timestamp = httpServletRequest.getHeader("Timestamp");
		String platform = httpServletRequest.getHeader("Platform");
		String sign = httpServletRequest.getHeader("Sign");
		Map<String, Object> params = new HashMap<>();
		params.put("Timestamp", timestamp);
		params.put("Platform", platform);
		params.put("PublicKey", "A4GNADCBiQKBgQDi7DfgJeRzqEiBgQDi");
		// pass the request along the filter chain

		if (httpServletRequest.getMethod().equals("GET")) {
			Enumeration<String> parameterNames = request.getParameterNames();
			while (parameterNames.hasMoreElements()) {
				String name = (String) parameterNames.nextElement();
				params.put(name, request.getParameter(name));
			}
			StringBuffer builder=HttpUtils.spellParams(params);
			if (sign.equals(MD5.encode(builder.toString()))) 
			{
				chain.doFilter(request, response);
			}else
			{
				responseResult.setCode(406);
				responseResult.setMessage("请求校验不通过");
//				responseResult.setData(new Object());
				PrintWriter out = response.getWriter();
				out.write(GsonUtil.gson().toJson(responseResult));
			}
		} else if (httpServletRequest.getMethod().equals("POST")) {
			StringBuffer jb = new StringBuffer();
			String line = null;
			String result = "";
			try {
				// 读取输入流到StringBuffer中
				BufferedReader reader = requestWrapper.getReader();
				while ((line = reader.readLine()) != null)
					jb.append(line);
			} catch (Exception e) {
				/* report an error */
				e.printStackTrace();
			}
			try {
				// 使用JSONObject的parseObject方法解析JSON字符串
				Gson gson = new Gson();
				Map<String, Object> map=new HashMap<>();
				map=gson.fromJson(jb.toString(), Map.class);
				params.putAll(map);
			} catch (Exception e) {
				// crash and burn
				throw new IOException("Error parsing JSON request string");
			}

			StringBuffer builder=HttpUtils.spellParams(params);
			if (sign.equals(MD5.encode(builder.toString()))) 
			{
				chain.doFilter(requestWrapper, response);
			}else
			{
				responseResult.setCode(406);
				responseResult.setMessage("请求校验不通过");
				responseResult.setData(new Object());
				PrintWriter out = response.getWriter();
				out.write(GsonUtil.gson().toJson(responseResult));
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
