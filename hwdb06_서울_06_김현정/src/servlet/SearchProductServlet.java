package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.Product;

@WebServlet("/searchProduct.do")
public class SearchProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String option = req.getParameter("option");
		String keyword = req.getParameter("keyword");
		ProductDAO productDAO = ProductDAO.getInstance();
		
		if(keyword == "") {
			resp.sendRedirect("productList.do");
		}else {
			List<Product> list = null;
			if(option.equals("name")) {	// 제목으로 검색
				list = productDAO.searchByName(keyword);
			}else if(option.equals("code")){							// 출판사로 검색
				list = productDAO.searchByCode(keyword);
			}
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/jsp/productList.jsp").forward(req, resp);
		}
		
	}
}
