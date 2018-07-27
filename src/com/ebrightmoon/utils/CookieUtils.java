package com.ebrightmoon.utils;
import javax.servlet.http.Cookie;

/**
 
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
