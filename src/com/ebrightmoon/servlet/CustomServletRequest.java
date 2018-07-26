package com.ebrightmoon.servlet;



import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 *  * 解决GET方式请求的中文乱码问题:
 *  * 自定义一个Request对象,覆盖或替换原本的Request对象.
 *  * 自定义的Request对象,按照个性需求修改getParameter()方法.
 *  * 解决GET方式的中文乱码.
 * @author Administrator
 *
 */

public class CustomServletRequest extends HttpServletRequestWrapper {

	/**
	 * 为什么要重写ServletRequest类型的构造函数?
	 *  * 底层语法强制要求(不写语法报错).
	 *  * 将原本Request对象中的数据内容,接收回来.
	 * @param request:就是原本的Request对象.
	 */
	public CustomServletRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String paramValue = super.getParameter(name);
		
		try {
			if(paramValue != null){
				paramValue = new String(paramValue.getBytes("ISO-8859-1"),"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return paramValue;
	}

}
