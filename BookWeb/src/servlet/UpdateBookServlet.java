package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/updateBook.do")
public class UpdateBookServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		BookVO book = new BookVO();
		book.setBookid(Integer.valueOf(req.getParameter("bookid")));
		book.setTitle(req.getParameter("title"));
		book.setPublisher(req.getParameter("publisher"));
		book.setYear(req.getParameter("year"));
		book.setPrice(Integer.valueOf(req.getParameter("price")));
		
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.updateBook(book);
		
		resp.sendRedirect("bookList.do");
	}
}
