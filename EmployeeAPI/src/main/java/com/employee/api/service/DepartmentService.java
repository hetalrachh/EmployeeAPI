package com.employee.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.api.bean.Department;

@Service
public interface DepartmentService {
	public boolean addDepartment(Department dept);

	public List<Department> getDepartments();

	public Department getDepartment(int id);

	public boolean updateDepartment(Department dept);

	public boolean deleteDepartment(int id);

}
