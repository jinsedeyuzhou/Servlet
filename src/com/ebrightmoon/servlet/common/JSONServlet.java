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
 * Servlet implementation class JsonServlet ����һ
 * response.setContentType("application/json");
 * response.setCharacterEncoding("UTF-8");
 * request.setCharacterEncoding("UTF-8"); ����json BufferedReader reader
 * =request.getReader(); String json = reader.readLine();
 * System.out.println(json); reader.close(); ����json PrintWriter out
 * =response.getWriter(); out.write("{\"name\":\"�赸��\"}"); out.close(); ������
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
 * // ת�������� InputStream is = new ByteArrayInputStream(
 * "{\"name\":\"�˵�\"}".getBytes()); // ��������� ServletOutputStream op =
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
			// ��ȡ��������StringBuffer��
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
			// ʹ��JSONObject��parseObject��������JSON�ַ���
			Gson gson = new Gson();
			userInfo = gson.fromJson(jb.toString(), UserInfo.class);
		} catch (Exception e) {
			// crash and burn
			throw new IOException("Error parsing JSON request string");
		}
		// �Ƚ��������յ���JSON�ַ�����ӡ���ͻ��ˣ��ٽ����ַ���ת��ΪJSON����Ȼ����ת���ɵ�JSON�ַ�����ӡ���ͻ���
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
