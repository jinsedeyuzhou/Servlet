package com.ebrightmoon.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import com.ebrightmoon.bean.UserInfo;
import com.google.gson.Gson;

public class JsonToObject {

	public static  <T>  T jsonToObject(Class<T> clazz,HttpServletRequest request)
	{
		StringBuffer jb = new StringBuffer();
		T userInfo = null;
		String line = null;
		String result = "";
		try {
			// ��ȡ��������StringBuffer��
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			/* report an error */
			e.printStackTrace();
		}
		try {
			// ʹ��JSONObject��parseObject��������JSON�ַ���
			Gson gson = new Gson();
			userInfo = gson.fromJson(jb.toString(),clazz);
		} catch (Exception e) {
			// crash and burn
			try {
				throw new IOException("Error parsing JSON request string");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return userInfo;
	}
}
