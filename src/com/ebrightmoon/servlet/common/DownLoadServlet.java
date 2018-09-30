package com.ebrightmoon.servlet.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		upload(request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 上传 
	 */
	private void upload(HttpServletRequest request)
	{
		// 创建DiskFileItemFactory文件项工厂对象
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 通过工厂对象获取文件上传请求核心解析类ServletFileUpload
				ServletFileUpload upload = new ServletFileUpload(factory);
				try {
					// 使用ServletFileUpload对应Request对象进行解析
					List<FileItem> items = upload.parseRequest(request);
					// 遍历每个fileItem
					for (FileItem fileItem : items) {
						// 判断fileItem是否是上传项
						if (fileItem.isFormField()) {
							// 返回true:表示不是上传项
							String fieldName = fileItem.getFieldName();
							String str = fileItem.getString("utf-8");
							System.out.println(fieldName+" : "+str);
						}else{
							// 返回false:表示是上传项
							String name = fileItem.getName();
							InputStream in = fileItem.getInputStream();
							
							String uploadPath = getServletContext().getRealPath("/WEB-INF/upload");
							OutputStream out = new FileOutputStream(new File(uploadPath, name));
							int b;
							while ((b = in.read()) != -1) {
								out.write(b);
							}
							out.close();
							in.close();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
}
