package com.example.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer>{
	
}
