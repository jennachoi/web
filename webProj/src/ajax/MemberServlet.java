package ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	// 조회작업
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// 조회 SQL 작성
		Connection conn = DBCon.getConnect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select member_id, member_name, member_age from member order by member_id";
		String json = "[";

		try {
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String memId = rs.getString(1);
				String memName = rs.getString(2);
				int memAge = rs.getInt(3);

				json += "{\"id\":\"" + memId + 
						"\",\"name\":\"" + memName + 
						"\",\"age\":" + memAge +"}";
				if(!rs.isLast()) 
					json += ",";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		json += "]";
		
//		 조회 결과를 json형식으로 작성해보세요
//		 [{"id":"1", "name":"hong","age":20},
//		 "id":"1", "name":"hong","age":20},
//		 "id":"1", "name":"hong","age":20}]
//
//		 결과를 response.getWriter().print();로 출력해보세요.
		response.getWriter().print(json);

//		 response.getWriter().print("<h2>정상적으로 조회되었습니다</h2>");
	}

	// 입력작업
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
		} // {"id":"1","name":"hong","age":"20"}을 출력한 것
		String json = "{\"id\":" + p1 + ","
					+ "\"name\":\"" + p2 + "\","
					+ "\"age\":" + p3 + "}";
		
//		"{"id":5,"name":"hong5","age":25}[{"id":"1","name":"hong","age":20},{"id":"2","name":"hong2","age":22},{"id":"3","name":"hong3","age":23},{"id":"4","name":"hong4","age":24},{"id":"5","name":"hong5","age":25},{"id":"11","name":"hong1","age":21}]"
		response.getWriter().print(json);
//		doGet(request, response);
	}

}
