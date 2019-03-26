package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.BookDAO;
import mvc.service.BookService;
import mvc.vo.Book;

//FrontController에서 넘어온 요청을 DAO에 넘겨서 작업지시하는 객체
//DAO 한테서 받은 결과를 저장(req에다가)하고 JSP로 넘어감 (forward 방식으로)
public class BookController {
	BookService dao;
	
	public BookController() {
		dao = new BookDAO();
	}
	
	//전체 리스트 조회
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Book> list = dao.selectAll();
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//book 하나 조회
	public void read(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		Book customer = dao.selectOne(isbn);
		req.setAttribute("book", customer);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/read.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	//book 삭제
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		dao.delete(isbn);
		
		list(req, res);
		
	}

	//book 추가 페이지 띄우기
	public void insertForm(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/insertForm.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	//book 추가
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("num1") + "-" + req.getParameter("num2") + "-"
				+ req.getParameter("num3");
		String title = req.getParameter("title");
		String catalogue = req.getParameter("catalogue");
		String nation = req.getParameter("nation");
		String date = req.getParameter("date");
		String publisher = req.getParameter("publisher");
		String author = req.getParameter("author");
		int price = Integer.parseInt(req.getParameter("price"));
		String currency = req.getParameter("currency");
		String description = req.getParameter("description");

		if(dao.selectOne(isbn) == null) { // 해당 isbn이 없을때만
			dao.insert(new Book(isbn, title, catalogue, nation, date, publisher, author, price, currency, description));
		}
		
		list(req, res);
		
	}

	//book 검색
	public void search(HttpServletRequest req, HttpServletResponse res) {
		String option = req.getParameter("option");
		String searchValue = req.getParameter("searchValue");
		
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		if(option.equals("isbn")){
			Book b = dao.searchByIsbn(searchValue);
			if(b != null){
				searchList.add(b);
				req.setAttribute("list", searchList);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
				try {
					dispatcher.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}else if(option.equals("title")){
			 ArrayList<Book> b = dao.searchByTitle(searchValue);
			 if(b.size() != 0){
				 searchList = b;
				 req.setAttribute("list", searchList);

				 RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
				 try {
					 dispatcher.forward(req, res);
				 } catch (ServletException | IOException e) {
					 e.printStackTrace();
				 }
			 }
		}else if(option.equals("publisher")){
			ArrayList<Book> b = dao.searchByPublisher(searchValue);
			if(b.size() != 0){
				searchList = b;
				req.setAttribute("list", searchList);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
				try {
					dispatcher.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			
		}else if(option.equals("price")){
			int price = Integer.parseInt(searchValue);
			ArrayList<Book> b = dao.searchByPrice(price);
			if(b.size() != 0){
				searchList = b;
				req.setAttribute("list", searchList);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
				try {
					dispatcher.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
}
