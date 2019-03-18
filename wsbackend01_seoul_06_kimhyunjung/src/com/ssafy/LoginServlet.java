package com.ssafy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if(id.equals("ssafy") && pass.equals("1111")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/Result.html");//화면 넘길 준비
			dispatcher.forward(request, response);//화면 넘김
		}
		
	}

}
