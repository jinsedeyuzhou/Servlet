package com.ebrightmoon.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebrightmoon.bean.UserInfo;
import com.google.gson.Gson;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONServlet() {
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
		UserInfo info=null;
		StringBuffer jb = new StringBuffer();
		String line = null;
		String result = "";
		try {
			// 读取输入流到StringBuffer中
			BufferedReader reader = request.getReader();
			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(request.getInputStream(),"utf-8"));

			while ((line = reader.readLine()) != null)
				jb.append(line);

		} catch (Exception e) {
			/* report an error */ }

		try {
			// 使用JSONObject的parseObject方法解析JSON字符串
			Gson gson = new Gson();
			userInfo = gson.fromJson(jb.toString(), UserInfo.class);
		} catch (Exception e) {
			// crash and burn
			throw new IOException("Error parsing JSON request string");
		}
		// 先将服务器收到的JSON字符串打印到客户端，再将该字符串转换为JSON对象然后再转换成的JSON字符串打印到客户端
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		ServletOutputStream out =response.getOutputStream();
		PrintWriter out = response.getWriter();
		out.write(userInfo.toString());
//		out.write(userInfo.toString().getBytes("utf-8"));
//		out.println(jb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
