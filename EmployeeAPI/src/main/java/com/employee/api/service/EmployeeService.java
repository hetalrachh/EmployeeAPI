package com.employee.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.api.bean.Employee;

@Service
public interface EmployeeService {

	public boolean addEmployee(Employee emp);

	public List<Employee> getEmployees();

	public Employee getEmployee(int id);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int id);

}
