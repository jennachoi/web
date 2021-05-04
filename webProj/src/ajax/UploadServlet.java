package ajax;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServletException, IOException {
//		System.out.println("service call()"); // service : GET,POST 상관 없이 호출하는 메소드임
//		Enumeration<String> enumer = req.getHeaderNames();  // Enumeration 여러가지 정보를 가져오는 명령어
//		while(enumer.hasMoreElements()) {
//			String key = enumer.nextElement();
//			String val = req.getHeader(key);
//			System.out.println(key + " : " + val);
//		}
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet call()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost call()");
		String path = "c:/tmp";
		
		ServletContext sc = this.getServletContext(); // 
		path = sc.getRealPath("upload"); // upload를 path 위치로
		
		MultipartRequest multi = new MultipartRequest(request, path, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
															  //저장위치   크기(byte) 5MB로지정  인코딩타입   이름중복시 이 클래스의 생성자로 지정
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()) { // 가지고 올 요소가 있는지 체크
			String name = (String) en.nextElement(); // 오브젝트타입으로 강제로 형변환
			String fileName = multi.getFilesystemName(name);
			System.out.println("name: " + name + ", fileName: " + fileName);
		}
	}

}
