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

		if (dept == null) {
			list = dao.getEmpList();
		} else {
			list = dao.getEmpByDept(dept);
		}

		String jsonData = "[";
		int cnt = 0;

		// [{"empId":"?", "fName":"?", "lName":"?" }, ... ] 와 같이 json 형식으로
		for (Employee emp : list) {
			jsonData += ("{\"empId\":\"" + emp.getEmployeeId() + "\", "
					+ "\"fName\":\"" + emp.getFirstName() + "\", "
					+ "\"lName\":\"" + emp.getLastName() + "\", "
					+ "\"email\":\"" + emp.getEmail() + "\", "
					+ "\"hiredate\":\"" + emp.getHireDate() + "\", "
					+ "\"JobId\":\""+ emp.getJobId() + "\", "
					+ "\"salary\":\""+ emp.getSalary() + "\"}"); 
			
			// "" 는 스트링타입을 선언, \는 escape해서 따옴표를 그대로 출력해줌
			if (++cnt == list.size()) { // 마지막 데이터에는 콤마안찍기
				continue;
			}
			jsonData += ",";
		}
		jsonData += "]";
		out.println(jsonData);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String hireDate = req.getParameter("hire_date");
		String jobId = req.getParameter("job_id");
		String salary = req.getParameter("salary");
		int sal = Integer.parseInt(salary);

		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setHireDate(hireDate);
		emp.setJobId(jobId);
		emp.setSalary(sal);
		

		EmpDAO dao = new EmpDAO();
		Employee empl = dao.insertEmpBySeq(emp);

		// {"eid":"?","fName":"?" ... } 이런 형식으로 사용자가 입력한 값을 함께 다시 출력하도록 만들어줘야 함.
		PrintWriter out = resp.getWriter();
		out.print("{\"empId\":\"" + empl.getEmployeeId() + "\", "
				+ "\"fName\":\"" + empl.getFirstName() + "\", "
				+ "\"lName\":\"" + empl.getLastName() + "\", "
				+ "\"email\":\"" + empl.getEmail() + "\", "
				+ "\"hiredate\":\"" + empl.getHireDate() + "\", "
				+ "\"JobId\":\""+ empl.getJobId() + "\", "
				+ "\"salary\":\""+ empl.getSalary() + "\"}"); 
	}
}
