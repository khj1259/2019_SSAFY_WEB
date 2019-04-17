package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/deleteBook.do")
public class DeleteBookServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookid = Integer.valueOf(req.getParameter("bookid"));
		BookDAO bookDAO = BookDAO.getInstance();
		BookVO book = new BookVO();
		book.setBookid(bookid);
		bookDAO.deleteBook(book);
		
		resp.sendRedirect("bookList.do");
	}
}
