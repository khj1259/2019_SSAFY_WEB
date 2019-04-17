package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.Product;

@WebServlet("/deleteProduct.do")
public class DeleteProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		ProductDAO productDAO = ProductDAO.getInstance();
		Product product = new Product();
		product.setCode(code);
		productDAO.deleteBook(product);
		
		resp.sendRedirect("productList.do");
	}
}
