package com.example.employee.dao;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee findEmployee(int employeeId);
	public int addEmployee(Employee employee);
	public String deleteEmployee(int employeeId);
}
