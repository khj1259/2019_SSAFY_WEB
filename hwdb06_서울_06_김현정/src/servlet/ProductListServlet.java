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

@WebServlet("/productList.do")
public class ProductListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = ProductDAO.getInstance();
		List<Product> list = productDAO.selectAll();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/jsp/productList.jsp").forward(req, resp);
		
	}
}
