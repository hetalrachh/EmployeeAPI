package com.employee.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.api.bean.Department;
import com.employee.api.dao.DepartmentDAO;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO deptDAO;

	public boolean addDepartment(Department dept) {
		boolean success = deptDAO.insertDepartment(dept);
		return success;
	}

	@Override
	public List<Department> getDepartments() {
		return deptDAO.getDepartments();
	}

	@Override
	public Department getDepartment(int id) {
		return deptDAO.getDepartment(id);
	}

	@Override
	public boolean updateDepartment(Department dept) {
		return deptDAO.updateDepartment(dept);
	}

	@Override
	public boolean deleteDepartment(int id) {
		return deptDAO.deleteDepartment(id);
	}

}
