package com.employee.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.api.bean.Department;

@Repository
public interface DepartmentDAO {

	public boolean insertDepartment(Department dept);

	public List<Department> getDepartments();

	public Department getDepartment(int id);

	public boolean updateDepartment(Department dept);

	public boolean deleteDepartment(int id);

}
