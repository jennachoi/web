package ajax;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jQuery/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init call()"); // 서버에서 실행될때 제일먼저 호출되는 메소드
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("service call()");
		Enumeration<String> enumer = req.getHeaderNames();  // Enumeration 여러가지 정보를 가져오는 명령어
		while(enumer.hasMoreElements()) {
			String key = enumer.nextElement();
			String val = req.getHeader(key);
			System.out.println(key + " : " + val);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet call()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost call()");
	}

}
