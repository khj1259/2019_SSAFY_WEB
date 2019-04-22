package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.IMemberDAO;
import com.ssafy.model.Member;
import com.ssafy.model.MemberDAOImpl;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IMemberDAO dao=new MemberDAOImpl();
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    		throws ServletException, IOException {
    	doPost(req,res);
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action=request.getParameter("action");
		if(action ==null){
			response.sendRedirect("index.jsp");
			return;
		}
		if(action.equalsIgnoreCase("LOGIN")){
			login(request, response);
			return;
		}else if(action.equalsIgnoreCase("MEMBERSAVE")){
			memberSave(request,response);
			return;
		}else if(action.equalsIgnoreCase("MEMBERREG")){
			//response.sendRedirect("member/Member.html");
			request.getRequestDispatcher("member/Member.html").forward(request,response);
			return;
		}else if(action.equalsIgnoreCase("LOGOUT")){
			HttpSession hs=request.getSession(false);
			if(hs != null){
				hs.invalidate();
			}			
		}
		response.sendRedirect("index.jsp");
	}
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String nextPage="Error.jsp";
		try {
			if(dao.loginCheck(user,pass)){
					HttpSession hs=request.getSession();
					hs.setAttribute("user", user);
					request.setAttribute("msg", "정상적으로 로그인 되었습니다");
			}else {
				System.out.println("아이디 또는 패스워드가 틀립니다.");
				String msg="아이디 또는 패스워드가 틀립니다.";
				request.setAttribute("msg", msg);
			}
			nextPage="index.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg","로그인 실패~~잠시 후 사용해 주세요");
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
	public  void logout(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
	
		
		res.sendRedirect("index.jsp");
	}
	
	public void memberSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ID");
		String pw=request.getParameter("PW");
		String name=request.getParameter("NAME");
		String nickName=request.getParameter("NICKNAME");
		String email=request.getParameter("EMAIL");
		String homePage=request.getParameter("HOMEPAGE");
		String address=request.getParameter("ADDRESS");
		String hobby=request.getParameter("HOBBY");
		String nextPage="Error.jsp";
		
		Member m=new Member();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		m.setNickName(nickName);
		m.setEmail(email);
		m.setHomePage(homePage);
		m.setAddress(address);
		m.setHobby(hobby);
		try{
			int result = dao.add(m);
			if(result == 1) {
				request.setAttribute("member", m);
				nextPage="member/MemberView.jsp";
			}else {
				request.setAttribute("msg", "회원 저장에 실패했습니다.");
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "회원 저장에 실패했습니다.");
	
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
