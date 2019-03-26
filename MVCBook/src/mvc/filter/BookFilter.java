package mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.BookController;

@WebFilter("*.mvc")
public class BookFilter implements Filter {
       
	BookController controller;

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		
		//클라이언트로부터 들어오는 요청을 구분하는 문자열
		//http://localhost:8080/mvc/list.mvc
		String reqString = req.getServletPath();
		if(reqString.equals("/list.mvc")) { //초기화면 요청
			controller.list(req, res);
			
		}else if(reqString.equals("/read.mvc")) { // 상세정보화면 요청
			controller.read(req, res);
			
		}else if(reqString.equals("/delete.mvc")) {
			controller.delete(req, res);
			
		}else if(reqString.equals("/insertForm.mvc")) {
			controller.insertForm(req, res);
			
		}else if(reqString.equals("/insert.mvc")) {
			controller.insert(req, res);
			
		}else if(reqString.equals("/search.mvc")) {
			controller.search(req, res);
			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		controller = new BookController();
	}

}
