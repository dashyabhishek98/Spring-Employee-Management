package com.example.employee.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView getEmployee() { 
		System.out.println("/employees");
		List<Employee> employee = employeeDao.findAll();
		System.out.println(employee);
		ModelAndView model = new ModelAndView(); 
		model.addObject("employee", employee);
		model.setViewName("index");
		return model;
	}
	
	@GetMapping("/showFormForSearch")
	public ModelAndView showFormForAdd() {
		System.out.println("/showFormForSearch");
		ModelAndView model = new ModelAndView();
		model.setViewName("searchEmployee");
		return model;
	}
	
	@PostMapping("/employee")
	public ModelAndView findEmployee(@RequestParam("employeeId") int Id){
		System.out.println("/employee/");
		System.out.println(Id);
		ModelAndView model = new ModelAndView();
		Optional<Employee> employee= employeeDao.findById(Id);
		System.out.println(employee);
		Employee emp = 	employee.get();
		System.out.println(emp);
		model.addObject("employee", emp);
		model.setViewName("searchedEmployee");
		return model;
	}
	@Transactional
	@PostMapping("/employee/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		return employeeDao.save(emp);
	}
	
	@DeleteMapping("/employee/delete")
	public String deleteEmployee(@RequestBody Employee employee) {
		employeeDao.delete(employee);
		return "Deleted";
	}
}
