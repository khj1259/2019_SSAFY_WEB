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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String comment = request.getParameter("comment");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Result.jsp");//화면 넘길 준비
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("comment", comment);
		dispatcher.forward(request, response);//화면 넘김
	}

}
