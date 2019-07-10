package com.ebrightmoon.servlet.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebrightmoon.bean.ResponseResult;
import com.ebrightmoon.bean.UserInfo;
import com.ebrightmoon.service.UserService;
import com.ebrightmoon.service.impl.UserServiceImpl;
import com.ebrightmoon.utils.GsonUtil;
import com.ebrightmoon.utils.HttpUtils;
import com.ebrightmoon.utils.MD5;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;



/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	 /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 response)
	 */
	 protected void doGet(HttpServletRequest request, HttpServletResponse
	 response) throws ServletException, IOException {
	 // TODO Auto-generated method stub
		
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
       
        String token="";
		ResponseResult responseResult = new ResponseResult<>();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserInfo userInfo = null;
		StringBuffer jb = new StringBuffer();
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
			userInfo = gson.fromJson(jb.toString(), UserInfo.class);
		} catch (Exception e) {
			// crash and burn
			throw new IOException("Error parsing JSON request string");
		}
		
		UserService service = new UserServiceImpl();
		if (!service.findUser(userInfo)) {
			token=MD5.encode(userInfo.getMobile()+userInfo.getUserPwd()+userInfo.getUuid()+System.currentTimeMillis());
			userInfo.setToken(token);
			boolean register = service.register(userInfo);
			// �Ƚ��������յ���JSON�ַ�����ӡ���ͻ��ˣ��ٽ����ַ���ת��ΪJSON����Ȼ����ת���ɵ�JSON�ַ�����ӡ���ͻ���
			responseResult.setCode(200);
			responseResult.setMessage("ע��ɹ���");
			responseResult.setData(userInfo);
		}else
		{
			responseResult.setCode(200);
			responseResult.setMessage("�û��Ѵ���");
			responseResult.setData(new Object());
		}
		
		PrintWriter out = response.getWriter();
		out.write(GsonUtil.gson().toJson(responseResult));

	}

}
