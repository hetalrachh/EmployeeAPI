package com.employee.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.bean.Employee;
import com.employee.api.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	// add a new employee
	@RequestMapping(value = "/employees/add", method = RequestMethod.POST)
	public String addEmployee(@RequestBody Employee emp) {
		boolean result = empService.addEmployee(emp);
		if (result) {
			return "Employee added";
		}
		return "Failed to add a new employee";

	}

	// get all employees
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return empService.getEmployees();
	}

	// get an employee based on id
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int id) {
		return empService.getEmployee(id);

	}
	
	// update employee details
	@RequestMapping(value="/employees/update", method=RequestMethod.PUT)
	public String updateEmployee(@RequestBody Employee emp) {
		boolean result = empService.updateEmployee(emp);
		if (result) {
			return "Employee details updated";
		}
		return "Failed to update employee details";

	}
	
	// delete an employee
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") int id) {
		boolean result = empService.deleteEmployee(id);
		if (result) {
			return "Employee details deleted";
		}
		return "Failed to delete employee details";

	}

}
