package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

@WebServlet("/searchBook.do")
public class SearchBookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String option = req.getParameter("option");
		String keyword = req.getParameter("keyword");
		BookDAO bookDAO = BookDAO.getInstance();
		
		if(keyword == "") {
			resp.sendRedirect("bookList.do");
		}else {
			List<BookVO> list = null;
			if(option.equals("title")) {	// 제목으로 검색
				list = bookDAO.searchByTitle(keyword);
			}else if(option.equals("publisher")){							// 출판사로 검색
				list = bookDAO.searchByPublisher(keyword);
			}
			req.setAttribute("bookList", list);
			req.getRequestDispatcher("/WEB-INF/jsp/bookList.jsp").forward(req, resp);
		}
		
	}
}
