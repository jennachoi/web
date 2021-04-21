package common;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO { // DB에서 데이터를 가져오는 작업
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	public Employee insertEmpBySeq(Employee emp) {
		conn = DBCon.getConnect();
		
		Employee empl = new Employee();

		String sql1 = "select employees_seq.nextval from dual";
		String sql2 = "insert into emp_temp(employee_id, last_name, email, hire_date, job_id) values(?, ?, ?, ?, ?)";
		try {
			int empId = 0;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				empId = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, empId);
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");
			
			//입력한 값을 반환해주기
			empl.setEmployeeId(empId);
			empl.setLastName(emp.getLastName());
			empl.setEmail(emp.getEmail());
			empl.setHireDate(emp.getHireDate());
			empl.setJobId(emp.getJobId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empl;
	}

	public void insertEMP(Employee emp) {
		String sql = "insert into emp_temp(employee_id, last_name, email, hire_date, job_id) values((select max(employee_id)+1 from emp_temp), ?, ?, ?, ?)";
		conn = DBCon.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHireDate());
			psmt.setString(4, emp.getJobId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");

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

	}

	public List<Employee> getEmpByDept(String dept) {
		// 사원정보를 가지고오는 처리
		String sql = "select * from emp_temp where department_id = " + dept + "order by employee_id";
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
				emp.setSalary(rs.getInt("Salary"));

				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
				emp.setSalary(rs.getInt("Salary"));

				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

}
