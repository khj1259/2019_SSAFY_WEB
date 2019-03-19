package com.ssafy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String num = request.getParameter("num1")
				+"-"+request.getParameter("num2")
				+"-"+request.getParameter("num3");
		String title = request.getParameter("title");
		String kind = request.getParameter("kind");
		String country = request.getParameter("country");
		String date = request.getParameter("date");
		String publisher = request.getParameter("publisher");
		String name = request.getParameter("name");
		String price = request.getParameter("price")+request.getParameter("unit");
		String summary = request.getParameter("summary");
		
		Book book = new Book(num, title, kind, country, date, publisher, name, price, summary);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Result.jsp");//화면 넘길 준비
		request.setAttribute("book", book);
		dispatcher.forward(request, response);//화면 넘김
	}

}
