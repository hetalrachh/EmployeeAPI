package com.employee.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.api.bean.Employee;

@Repository
public interface EmployeeDAO {

	public boolean insertEmployee(Employee emp);

	public List<Employee> retrieveEmployees();

	public Employee getEmployee(int id);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int id);

}
