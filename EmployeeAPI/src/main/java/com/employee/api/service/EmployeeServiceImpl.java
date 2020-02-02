package com.employee.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.api.bean.Employee;
import com.employee.api.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;

	@Override
	public boolean addEmployee(Employee emp) {
		boolean success = empDAO.insertEmployee(emp);
		return success;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = empDAO.retrieveEmployees();
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		return empDAO.getEmployee(id);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		boolean success = empDAO.updateEmployee(emp);
		return success;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean success = empDAO.deleteEmployee(id);
		return success;
	}

}
