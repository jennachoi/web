package fileBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDeleteServlet")
public class FileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		int fileNum = Integer.parseInt(num); // String으로 넘어온 값을 int로 형변환

		FileDAO dao = new FileDAO();
		FileVO vo = dao.DeleteFile(fileNum);

		response.getWriter().print(vo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
