package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empList.do") // 여기에 지정하는 방식에 따라 웹페이지 url 변경
public class EmpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String dept = req.getParameter("dept");
		EmpDAO dao = new EmpDAO();
		
		List<Employee> list = null;
		
		if(dept == null) {
			list = dao.getEmpList();
		}else {
			list = dao.getEmpByDept(dept);
		}
		
		String jsonData = "[";
		int cnt = 0;
		
		// [{"empId":"?", "fName":"?", "lName":"?" }, ... ] 와 같이 json 형식으로 
		for (Employee emp : list) {
			jsonData += ("{\"empId\":\"" + emp.getEmployeeId() 
			+ "\", \"fName\":\"" + emp.getFirstName()
			+ "\", \"lName\":\"" + emp.getLastName()
			+ "\", \"email\":\"" + emp.getEmail()
			+ "\", \"salary\":\"" + emp.getSalary()
					+ "\"}"); // "" 는 스트링타입을 선언, \는 escape해서 따옴표를 그대로 출력해줌 
			if(++cnt == list.size()) {  // 마지막 데이터에는 콤마안찍기
				continue;
			}
			jsonData += ",";
		}
		jsonData += "]";
		out.println(jsonData);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String hireDate = req.getParameter("hire_date");
		String jobId = req.getParameter("job_id");
		
		Employee emp = new Employee();
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setHireDate(hireDate);
		emp.setJobId(jobId);

		EmpDAO dao = new EmpDAO();
		dao.insertEMP(emp);
		
		resp.getWriter().print("<h1>Success</h1>");
	}
}
