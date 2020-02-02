package com.employee.api.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.employee.api.bean.Employee;

@Repository
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO {

	@Autowired
	DataSource dataSource;

	// initialize the data source after any DI or initialization is done
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public boolean insertEmployee(Employee emp) {

		String sql = "INSERT INTO EMPLOYEE (empid, firstname, lastname, address, deptid, emailid) VALUES (?,?,?,?,?,?)";
		int rows = getJdbcTemplate().update(sql, new Object[] { emp.getDeptId(), emp.getFirstName(), emp.getLastName(),
				emp.getAddress(), emp.getDeptId(), emp.getEmailId() });
		if (rows == 1) {
			return true;
		}

		return false;
	}

	@Override
	public List<Employee> retrieveEmployees() {
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> empList = new ArrayList<Employee>();
		List<Map<String, Object>> employees = getJdbcTemplate().queryForList(sql);

		for (Map<String, Object> e : employees) {
			Employee emp = new Employee();
			emp.setEmpId(((BigDecimal) e.get("empid")).intValue());
			emp.setFirstName((String) e.get("firstname"));
			emp.setLastName((String) e.get("lastname"));
			emp.setAddress((String) e.get("address"));
			emp.setDeptId(((BigDecimal) e.get("deptid")).intValue());
			emp.setEmailId((String) e.get("emailid"));
			empList.add(emp);

		}

		return empList;
	}

	@Override
	public Employee getEmployee(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPID=?";
		Employee result = (Employee) getJdbcTemplate().queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper(Employee.class));

		return result;
	}

	@Override
	public boolean updateEmployee(Employee emp) {

		// get the current employee details
		String esql = "SELECT * FROM EMPLOYEE WHERE EMPID=?";
		Employee eresult = (Employee) getJdbcTemplate().queryForObject(esql, new Object[] { emp.getEmpId() },
				new BeanPropertyRowMapper(Employee.class));

		Employee updateEmployee = eresult;
		updateEmployee.setEmpId(eresult.getEmpId());

		if (!eresult.getFirstName().equals(emp.getFirstName())) {
			updateEmployee.setFirstName(emp.getFirstName());
		}

		if (!eresult.getLastName().equals(emp.getLastName())) {
			updateEmployee.setLastName(emp.getLastName());
		}

		if (!eresult.getAddress().equals(emp.getAddress())) {
			updateEmployee.setAddress(emp.getAddress());
		}

		if (eresult.getDeptId() != emp.getDeptId()) {
			updateEmployee.setDeptId(emp.getDeptId());
		}

		if (!eresult.getEmailId().equals(emp.getEmailId())) {
			updateEmployee.setEmailId(emp.getEmailId());
		}

		String sql = "UPDATE EMPLOYEE SET EMPID=?, FIRSTNAME=?, LASTNAME=?, ADDRESS=?, DEPTID=?, EMAILID=? WHERE EMPID=?";
		int rows = getJdbcTemplate().update(sql,
				new Object[] { updateEmployee.getEmpId(), updateEmployee.getFirstName(), updateEmployee.getLastName(),
						updateEmployee.getAddress(), updateEmployee.getDeptId(), updateEmployee.getEmailId(),
						updateEmployee.getEmpId() });
		
		if(rows == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		String sql = "DELETE FROM EMPLOYEE WHERE EMPID=?";
		int rows = getJdbcTemplate().update(sql,
				new Object[] { id });

		if (rows == 1) {
			return true;
		}
		return false;
	}

}
