package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/detailBook.do")
public class DetailBookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookid = Integer.valueOf(req.getParameter("bookid"));
		BookDAO bookDAO = BookDAO.getInstance();
		BookVO book = bookDAO.selectOne(bookid);
		
		req.setAttribute("book", book);

		req.getRequestDispatcher("/WEB-INF/jsp/bookDetail.jsp").forward(req, resp);
	}
}
