package common;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO { // DB에서 데이터를 가져오는 작업
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	public Employee insertEmpBySeq(Employee emp) {
		conn = DBCon.getConnect();

		Employee empl = new Employee();

		String sql1 = "select employees_seq.nextval from dual";
		String sql2 = "insert into emp_temp(employee_id, first_name, last_name, email, hire_date, job_id, salary, department_id) "
				+ "values(?, ?, ?, ?, ?, ?, ?, 50)";
		try {
			int empId = 0;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				empId = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, empId);
			psmt.setString(2, emp.getFirstName());
			psmt.setString(3, emp.getLastName());
			psmt.setString(4, emp.getEmail());
			psmt.setString(5, emp.getHireDate());
			psmt.setString(6, emp.getJobId());
			psmt.setInt(7, emp.getSalary());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");

			// 입력한 값을 반환해주기
			empl.setEmployeeId(empId);
			empl.setFirstName(emp.getFirstName());
			empl.setLastName(emp.getLastName());
			empl.setEmail(emp.getEmail());
			empl.setHireDate(emp.getHireDate());
			empl.setJobId(emp.getJobId());
			empl.setSalary(emp.getSalary());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empl;
	}

	public void insertEMP(Employee emp) {
		String sql = "insert into emp_temp(employee_id, first_name, last_name, email, hire_date, job_id, salary) values((select max(employee_id)+1 from emp_temp), ?, ?, ?, ?, ?, ?)";
		conn = DBCon.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			psmt.setInt(6, emp.getSalary());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public List<Employee> getEmpByDept(String dept) {
		// 사원정보를 가지고오는 처리
		String sql = "select employee_id, first_name, last_name, email, to_char(hire_date, 'YYYY/MM/DD') as hire_date, job_id, salary from emp_temp where department_id = "
				+ dept + "order by employee_id";
		conn = DBCon.getConnect();
		List<Employee> employees = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("Last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));

				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return employees;

	}

	public List<Employee> getEmpList() {
		// 사원정보를 가지고오는 처리
		String sql = "select * from emp_temp order by employee_id";
		conn = DBCon.getConnect();
		List<Employee> employees = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("Last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));

				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return employees;
	}

	// empl_demo

	public List<Employee> getEmployeeList() {
		// 사원정보를 가지고오는 처리
		String sql = "select * from empl_demo order by employee_id";
		conn = DBCon.getConnect();
		List<Employee> employees = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("Last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setPhoneNumber(rs.getString("phone_number"));

				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return employees;
	}

	// 구글 차트에 쓸 서블릿 map 타입으로 적어주기
	public Map<String, Integer> getEmployeeByDept() {
		// 부서명, 사원수 가져오기
		Map<String, Integer> map = new HashMap<>();

		String sql = "select d.department_name, count(1)\r\n" + "from empl_demo e, departments d\r\n"
				+ "where e.department_id = d.department_id\r\n" + "group by d.department_name";
		conn = DBCon.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return map;
	}

	// 스케줄 정보를 가지고 오는 메소드.
	public List<ScheduleVO> getScheduleList() {
		conn = DBCon.getConnect();
		
		String sql = "Select * from schedule";
		List<ScheduleVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ScheduleVO vo = new ScheduleVO();
				vo.setTitle(rs.getString("title"));
				vo.setStartDay(rs.getString("start_day"));
				vo.setEndDay(rs.getString("end_day"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}
	
	
	// 입력한 스케줄 정보를 DB에 기록하는 메소드 (한건 입력)
	public void insertSchedule(ScheduleVO vo) {
		conn = DBCon.getConnect();

		String sql = "insert into schedule values(?, ?, ?)";
		
		try {
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDay());
			psmt.setString(3, vo.getEndDay());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}
	
	// 클릭한 스케줄 정보를 DB에 삭제하는 메소드
	public void DeleteSchedule(ScheduleVO vo) {
		conn = DBCon.getConnect();

		String sql = "delete from schedule where title=?";
		
		try {
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void close() {
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

}
