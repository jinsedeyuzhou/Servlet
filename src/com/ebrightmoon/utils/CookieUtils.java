package com.ebrightmoon.utils;
import javax.servlet.http.Cookie;

/**
 * 封装获取客户端Cookie信息的工具类.
 * @author JYL
 */
public class CookieUtils {

	public static Cookie getCookie(Cookie[] cookies, String name){
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie != null){
					if(name.equals(cookie.getName())){
						return cookie;
					}
				}
			}
		}
		return null;
	}
	
}
