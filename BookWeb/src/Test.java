import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 정적인 페이지만 제공하는 웹에서 => 동적인 페이지를 제공하기 위해서
 * 1. Servlet 로 제공하기 시작
 * 2. jsp 로 제공하기 시작
 */
//@WebServlet("/asdf")
public class Test extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		// 동적으로 자바코드로, html 화면을 만듦
		resp.getWriter().append("서버 :").append(req.getContextPath());
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("<body>");
		Date date = new Date();
		
		pw.write("</body>");
		pw.write("</html>");
		
	}
}
