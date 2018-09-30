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
		//��һ�����ȶ���ͼ��Ĵ�С
		int width = 200;
		int height = 35;
		//�ڶ���������һ���ڴ�ͼ��Ķ��󣬴��ͼ�����Ϣ
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//���������õ����ʣ�׼����ͼ
		Graphics g = image.getGraphics();
		/*
		 * 1 ������ɫ������ɫ��	��䱳��ɫ
		 * 2 ������ɫ���߿���ɫ��	���߿���ɫ
		 * 3 ������ɫ�������ߣ� 	��������
		 * 4 ������ɫ��������֤�룩  �����֤�� ��������֤�������С�� 
		 */
		g.setColor(Color.GRAY);
		g.fillRect(1, 1, width-2, height-2);
		
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width, height);
	
		g.setColor(Color.WHITE);
		Random r = new Random();//����������������ڻ������ߺͲ�����֤��
		for(int i=0;i<10;i++){
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		//���������������
		g.setFont(new Font("����",Font.BOLD,30));
		
		g.setColor(Color.RED);
		int x = 30;
		for(int i=0;i<4;i++){
			String num=String.valueOf(r.nextInt(9));
			g.drawString(num, x, 25);//String.valueOf()   new Integer().toString()    +""  Ч���ɸߵ���
			x+=30;
			builder.append(num);
		}
		System.out.println("VerificationCodeServlet:"+builder.toString());
		//����ÿ�ζ���ʹ�û���
		response.setHeader("Expires","-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		
		
		//���ڴ��л��õ�ͼ��������������,ʹ��ImageIO�����write�������,�÷�������������
		//��һ���������ڴ���󣬵ڶ���������ͼ�����չ��  �����������������
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
