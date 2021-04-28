package ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBCon;

@WebServlet("/jQuery/memberServlet.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 없어도 상관 X

	public MemberServlet() {
		super();
	}

	//조회작업
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//조회 SQL 작성
		//조회 결과를 json형식으로 작성해보세요
		// [{"id":1, "name":"hong","age":20},
		//   "id":1, "name":"hong","age":20},
		//   "id":1, "name":"hong","age":20}]
		//결과를 response.getWriter().print();로 출력해보세요.
		
		
		
		response.getWriter().print("<h2>정상적으로 조회되었습니다</h2>");
	}
	
	//입력작업
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p1 = request.getParameter("m_id"); // m_id의 값을불러오는 명령어는 getParameter, p1에 넣어줌
		String p2 = request.getParameter("m_name");
		String p3 = request.getParameter("m_age");
		
		Connection conn = DBCon.getConnect();
		PreparedStatement psmt = null;
		String sql = "insert into member values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p1);
			psmt.setString(2, p2);
			psmt.setString(3, p3);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("<h2>정상적으로 입력되었습니다</h2>");
		doGet(request, response);
	}

}
