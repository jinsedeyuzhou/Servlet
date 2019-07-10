package com.ebrightmoon.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebrightmoon.bean.NewsFeed;
import com.ebrightmoon.bean.ResponseResult;
import com.ebrightmoon.service.NewsFeedService;
import com.ebrightmoon.service.impl.NewsFeedServiceImpl;
import com.ebrightmoon.utils.GsonUtil;

/**
 * Servlet implementation class NewsFeedServlet
 */
@WebServlet("/GetNewsFeed")
public class NewsFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsFeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		ResponseResult<List<NewsFeed>> responseResult=new ResponseResult<List<NewsFeed>>();
		NewsFeedService newsFeedService=new NewsFeedServiceImpl();
		List<NewsFeed> newsFeeds = newsFeedService.findTenNews();
		Enumeration<String> parameterNames = request.getParameterNames();
		responseResult.setCode(200);
		responseResult.setMessage("获取数据成功");
		responseResult.setData(newsFeeds);
		PrintWriter out = response.getWriter();
		out.write(GsonUtil.gson().toJson(responseResult));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
