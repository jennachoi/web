package fileBoard;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("doPost call()");
		String path = "c:/tmp";

		ServletContext sc = this.getServletContext(); //
		path = sc.getRealPath("upload"); // upload를 path 위치로

		MultipartRequest multi = new MultipartRequest(request, path, 5 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());
		// 저장위치 크기(byte) 5MB로지정 인코딩타입 이름중복시 이 클래스의 생성자로 지정
		Enumeration en = multi.getFileNames();
		String author = multi.getParameter("author");
		String title = multi.getParameter("title");
		String fileN = null;
		
		while (en.hasMoreElements()) { // 가지고 올 요소가 있는지 체크
			String name = (String) en.nextElement(); // 오브젝트타입으로 강제로 형변환
			String fileName = multi.getFilesystemName(name);
			fileN = fileName;
			System.out.println("name: " + name + ", fileName: " + fileName);
			
		}
		// 입력 후 저장된 값 가져오기.
		FileDAO dao = new FileDAO();
		FileVO vo = new FileVO();
		vo.setAuthor(author);
		vo.setFileName(fileN);
		vo.setTitle(title);
		FileVO rvo = dao.getInsertKeyVal(vo);
		
		// 가져온 값을 json으로 생성. {"num":?, "author":?, "title":?, ... }
		JSONObject obj = new JSONObject();
		obj.put("num", rvo.getNum());
		obj.put("author", rvo.getAuthor());
		obj.put("title", rvo.getTitle());
		obj.put("day", rvo.getDay());
		obj.put("file_Name", rvo.getFileName());
	
		response.getWriter().print(obj);
	}
}