package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax.do")  // 이렇게 페이지 주소를 명시
public class AjaxServlet extends HttpServlet {
								// 톰캣이 가지고 있는 클래스. 웹페이지를 통해서 서블릿 페이지를 요청하는 기능을 가지고 있다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						//ㄴ클라이언트로부터 온 요청을 담는곳  ㄴ결과값을 받아서 반환해주는곳
		String p1 = req.getParameter("p1"); // 사용자가 입력한 파라메터
		String p2 = req.getParameter("p2");
		resp.getWriter().print("<h1>Ajax Get Page</h1>");
		resp.getWriter().print("<h3>"+p1+","+p2+"</h3>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("<h1>Ajax Post Page</h1>");
	}
	
	
	
}
