package com.ebrightmoon.servlet.common;

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
 * Servlet implementation class JsonServlet 方法一
 * response.setContentType("application/json");
 * response.setCharacterEncoding("UTF-8");
 * request.setCharacterEncoding("UTF-8"); 接收json BufferedReader reader
 * =request.getReader(); String json = reader.readLine();
 * System.out.println(json); reader.close(); 返回json PrintWriter out
 * =response.getWriter(); out.write("{\"name\":\"舞蹈家\"}"); out.close(); 方法二
 * 
 * response.setContentType("application/json");
 * response.setCharacterEncoding("UTF-8");
 * request.setCharacterEncoding("UTF-8");
 * 
 * 
 * BufferedReader br = new BufferedReader(new InputStreamReader(
 * (ServletInputStream) request.getInputStream(), "utf-8")); StringBuffer sb =
 * new StringBuffer(""); String temp; while ((temp = br.readLine()) != null) {
 * sb.append(temp); } br.close(); System.out.println(sb.toString());
 * 
 * 
 * 
 * 
 * // 转成数据流 InputStream is = new ByteArrayInputStream(
 * "{\"name\":\"账单\"}".getBytes()); // 输出到画面 ServletOutputStream op =
 * response.getOutputStream(); int len; byte[] buff = new byte[4096]; while
 * ((len = is.read(buff)) != -1) { op.write(buff, 0, len); } op.flush();
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
		if (request.getMethod().equals("GET")) {
			
		}
		UserInfo info = null;
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
			/* report an error */
			e.printStackTrace();
		}

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
		// ServletOutputStream out =response.getOutputStream();
		PrintWriter out = response.getWriter();
		out.write(userInfo.toString());
		// out.write(userInfo.toString().getBytes("utf-8"));
		// out.println(jb.toString());
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
