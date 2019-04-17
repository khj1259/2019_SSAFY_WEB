package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.Product;

@WebServlet("/updateProduct.do")
public class UpdateBookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		ProductDAO productDAO = ProductDAO.getInstance();
		Product product = productDAO.selectOne(code);
		
		req.setAttribute("product", product);
		req.getRequestDispatcher("/WEB-INF/jsp/updateProduct.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		Product product = new Product();
		product.setCode(req.getParameter("code"));
		product.setName(req.getParameter("name"));
		product.setPrice(Integer.valueOf(req.getParameter("price")));
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.updateBook(product);
		
		resp.sendRedirect("productList.do");
	}
}
