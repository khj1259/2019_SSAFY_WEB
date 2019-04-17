package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.Product;

@WebServlet("/detailProduct.do")
public class DetailProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		ProductDAO productDAO = ProductDAO.getInstance();
		Product product = productDAO.selectOne(code);
		
		req.setAttribute("product", product);

		req.getRequestDispatcher("/WEB-INF/jsp/productDetail.jsp").forward(req, resp);
	}
}
