package com.employee.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.bean.Department;
import com.employee.api.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService deptService;

	// add a new department
	@RequestMapping(value = "/department/add", method = RequestMethod.POST)
	public String addDepartment(@RequestBody Department dept) {
		boolean result = deptService.addDepartment(dept);
		if (result) {
			return "Department added";
		}
		return "Failed to add a new department";

	}

	// get all departments
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public List<Department> getDepartments() {
		return deptService.getDepartments();

	}

	// get a department based on id
	@RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
	public Department getDepartment(@PathVariable("id") int id) {
		return deptService.getDepartment(id);

	}

	// update department details
	@RequestMapping(value = "/departments/update", method = RequestMethod.PUT)
	public String updateDepartment(@RequestBody Department dept) {
		boolean result = deptService.updateDepartment(dept);
		if (result) {
			return "Department details updated";
		}
		return "Failed to update department details";

	}

	// delete a department
	@RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
	public String deleteDepartment(@PathVariable("id") int id) {
		boolean result = deptService.deleteDepartment(id);
		if (result) {
			return "Department details deleted";
		}
		return "Failed to delete department details";

	}

}
