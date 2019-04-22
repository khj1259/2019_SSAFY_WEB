package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.Book;
import com.ssafy.model.BookDAOImpl;
import com.ssafy.model.IBookDAO;

public class BookServlet extends HttpServlet {

	private IBookDAO dao = new BookDAOImpl();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	public void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		System.out.println("action:"+action);
		if (action.equals("SAVE")) {
			save(req, res);
		} else if (action.equals("VIEW")) {
			view(req, res);
		}else if (action.equals("DEL")) {
			delete(req, res);
		}else if (action.equals("SEARCH")) {
			search(req, res);
		}else if (action.equals("REGBOOK")) {
			//res.sendRedirect("book/Book.jsp");
			req.getRequestDispatcher("book/Book.jsp").forward(req, res);
		}else if (action.equals("DESC")) {
			desc(req, res);
		}
	}// process()
	public void desc(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String isbn = req.getParameter("isbn");
		System.out.println(isbn);
		String nextPage="Error.jsp";
		Book b;
		try {
			b = dao.search(isbn);
			req.setAttribute("result", b.getDescription());
			nextPage="book/DescResult.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","오류 발생,  다시 시도해 주세요.");
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void search(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String nextPage="Error.jsp";
		String field = req.getParameter("searchField");
		if(field == null) field="";
		String text = req.getParameter("searchText");
		if(text == null)  text="";
		field=field.trim();
		text=text.trim();
		System.out.println(field+":"+text);
		List<Book> result=null;
		try {
			switch(field){
			case "TITLE":			
					result=dao.searchByTitle(text);				
				break;
			case "PUBLISHER":
				result=dao.searchByPublisher(text);
				break;
			case "PRICE":
				result=dao.searchByPrice(Integer.parseInt(text));
				break;
			default :
				result=dao.search();
			}
			req.setAttribute("books", result );
			req.setAttribute("field", field );
			req.setAttribute("text", text );
			nextPage="book/BookList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	
	public void view(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String nextPage="Error.jsp";
		String isbn = req.getParameter("isbn").trim();
		try {
			req.setAttribute("b",dao.search(isbn) );
			nextPage="book/BookView.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String isbn = req.getParameter("isbn").trim();
		String nextPage="Result.jsp";
		try {
			req.setAttribute("msg", "정상적으로 삭제 되었습니다");
			dao.delete(isbn);
			System.out.println("삭제완료");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			nextPage="Error.jsp";
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void save(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		String isbn1 = req.getParameter("isbn1").trim();
		String isbn2 = req.getParameter("isbn2").trim();
		String isbn3 = req.getParameter("isbn3").trim();
		String isbn = isbn1 + "-" + isbn2 + "-" + isbn3;
		String title = req.getParameter("title").trim();
		String catalogue = req.getParameter("catalogue").trim();
		String nation = req.getParameter("nation").trim();
		String publishDate = req.getParameter("publishDate").trim();
		String publisher = req.getParameter("publisher").trim();
		String author = req.getParameter("author").trim();
		String price = req.getParameter("price").trim();
		int p = Integer.parseInt(price);
		String currency = req.getParameter("currency").trim();
		String description = req.getParameter("description").trim();
		Book book = new Book(isbn, title, catalogue, nation, publishDate,
				publisher, author, p, currency, description);
        
       
		String nextPage="Error.jsp";
		HttpSession hs = req.getSession();
		String user = (String) hs.getAttribute("user");
		if(user != null) {
			req.setAttribute("user", user);
		}
		try {
			dao.insertBook(book);
			req.setAttribute("book", book);
			req.setAttribute("msg", "정상적으로 저장 되었습니다");
			nextPage="Result.jsp";		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "저장 중 오류가 발행했습니다.");
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
}