package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.Product;

@WebServlet("/addProduct.do")
public class AddProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		req.getRequestDispatcher("/WEB-INF/jsp/addBook.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		Product product = new Product();
		product.setCode(req.getParameter("code"));
		product.setName(req.getParameter("name"));
		product.setPrice(Integer.valueOf(req.getParameter("price")));
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.insertProduct(product);
		
		// 도서의 전체 목록을 보여주는 bookList.do로 리다이렉션 하자
		resp.sendRedirect("productList.do");
	}
}
