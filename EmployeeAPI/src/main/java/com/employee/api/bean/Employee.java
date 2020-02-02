package com.employee.api.bean;

public class Employee {

	private int empId;
	private String firstName;
	private String lastName;
	private String address;
	private int deptId;
	private String emailId;

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [empdId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", deptId=" + deptId + ", emailId=" + emailId + "]";
	}

	public Employee(int empdId, String firstName, String lastName, String address, int deptId, String emailId) {
		super();
		this.empId = empdId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.deptId = deptId;
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
