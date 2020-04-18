package com.example.employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.entity.Employee;

@RestController
public class EmployeeRestController {

	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeRestController(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployee() { 
		System.out.println("1");
		return employeeDao.getEmployees();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee findEmployee(@PathVariable("employeeId") int Id){
		System.out.println(Id);
		return employeeDao.findEmployee(Id);
	}
	@Transactional
	@PostMapping("/employee/add")
	public int addEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		return employeeDao.addEmployee(emp);
	}
	
	@DeleteMapping("/employee/delete/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}
}
