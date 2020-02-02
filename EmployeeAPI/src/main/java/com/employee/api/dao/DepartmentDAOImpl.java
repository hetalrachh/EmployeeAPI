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

import com.employee.api.bean.Department;

@Repository
public class DepartmentDAOImpl extends JdbcDaoSupport implements DepartmentDAO {

	@Autowired
	DataSource dataSource;

	// initialize the data source after any DI or initialization is done
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public boolean insertDepartment(Department dept) {

		String sql = "INSERT INTO DEPARTMENT (deptid, deptname) VALUES (?,?)";
		getJdbcTemplate().update(sql, new Object[] { dept.getDeptId(), dept.getDeptName() });

		return true;

	}

	@Override
	public List<Department> getDepartments() {
		String sql = "SELECT * FROM DEPARTMENT";
		List<Department> deptList = new ArrayList<Department>();
		List<Map<String, Object>> department = getJdbcTemplate().queryForList(sql);

		for (Map<String, Object> e : department) {
			Department dept = new Department();
			dept.setDeptId(((BigDecimal) e.get("deptid")).intValue());
			dept.setDeptName((String) e.get("deptname"));
			deptList.add(dept);

		}
		return deptList;

	}

	@Override
	public Department getDepartment(int id) {
		String sql = "SELECT * FROM DEPARTMENT WHERE DEPTID=?";
		Department result = (Department) getJdbcTemplate().queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper(Department.class));

		return result;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		// get the current department details
		String dsql = "SELECT * FROM DEPARTMENT WHERE DEPTID=?";
		Department dresult = (Department) getJdbcTemplate().queryForObject(dsql, new Object[] { dept.getDeptId() },
				new BeanPropertyRowMapper(Department.class));

		Department updateDepartment = dresult;
		updateDepartment.setDeptId(dresult.getDeptId());

		if (!dresult.getDeptName().equals(dept.getDeptName())) {
			updateDepartment.setDeptName(dept.getDeptName());
		}


		String sql = "UPDATE DEPARTMENT SET DEPTID=?, DEPTNAME=? WHERE DEPTID=?";
		int rows = getJdbcTemplate().update(sql,
				new Object[] { updateDepartment.getDeptId(), updateDepartment.getDeptName(),
						updateDepartment.getDeptId() });

		if (rows == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDepartment(int id) {
		String sql = "DELETE FROM DEPARTMENT WHERE DEPTID=?";
		int rows = getJdbcTemplate().update(sql, new Object[] { id });

		if (rows == 1) {
			return true;
		}
		return false;
	}

}
