package com.ebrightmoon.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.ebrightmoon.utils.JsonToObject;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResponseResult responseResult = new ResponseResult<>();
		UserInfo userInfo=JsonToObject.jsonToObject(UserInfo.class, request);
		UserService service = new UserServiceImpl();
		UserInfo login = service.login(userInfo);
		if (login!=null) {
			responseResult.setCode(200);
			responseResult.setMessage("登录成功！");
			responseResult.setData(login);
		}else
		{
			responseResult.setCode(298);
			responseResult.setMessage("手机号或者密码错误");
			responseResult.setData(new Object());
		}

		

		PrintWriter out = response.getWriter();
		out.write(GsonUtil.gson().toJson(responseResult));
	}

}
