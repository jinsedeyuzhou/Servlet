package com.ebrightmoon.servlet.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerificationCodeServlet
 */
@WebServlet("/VerificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder builder=new StringBuilder();
		//第一步：先定义图像的大小
		int width = 200;
		int height = 35;
		//第二步：定义一个内存图像的对象，存放图像的信息
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//第三部：拿到画笔，准备画图
		Graphics g = image.getGraphics();
		/*
		 * 1 设置颜色（背景色）	填充背景色
		 * 2 设置颜色（边框颜色）	填充边框颜色
		 * 3 设置颜色（干扰线） 	填充干扰线
		 * 4 设置颜色（数子验证码）  填充验证码 （设置验证码字体大小） 
		 */
		g.setColor(Color.GRAY);
		g.fillRect(1, 1, width-2, height-2);
		
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width, height);
	
		g.setColor(Color.WHITE);
		Random r = new Random();//创建随机数对象，用于画干扰线和产生验证码
		for(int i=0;i<10;i++){
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		//设置随机数的字体
		g.setFont(new Font("宋体",Font.BOLD,30));
		
		g.setColor(Color.RED);
		int x = 30;
		for(int i=0;i<4;i++){
			String num=String.valueOf(r.nextInt(9));
			g.drawString(num, x, 25);//String.valueOf()   new Integer().toString()    +""  效率由高到低
			x+=30;
			builder.append(num);
		}
		System.out.println("VerificationCodeServlet:"+builder.toString());
		//设置每次都不使用缓存
		response.setHeader("Expires","-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		
		
		//把内存中画好的图像，输出到浏览器上,使用ImageIO对象的write方法输出,该方法有三个参数
		//第一个参数是内存对象，第二个参数是图像的扩展名  第三个参数是输出流
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
