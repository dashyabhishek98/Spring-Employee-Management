package com.example.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

	EntityManagerFactory entityManager;
	
	@Autowired
	public void setEntityManager(EntityManagerFactory entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public List<Employee> getEmployees() {
		EntityManager currentSession = entityManager.createEntityManager();
		TypedQuery<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> employees  = theQuery.getResultList();
		System.out.println(employees);
		return employees;
	}
	
	public Employee findEmployee(int employeeId) {
		EntityManager currentSession = entityManager.createEntityManager();
		Employee employee = currentSession.find(Employee.class, employeeId);
		return employee;
	}
	
	public int addEmployee(Employee employee) {
		EntityManager currenrtSession = entityManager.createEntityManager();
		currenrtSession.getTransaction().begin();
		Employee emp = currenrtSession.merge(employee);
		currenrtSession.getTransaction().commit();
		System.out.println(emp.getId());
		return emp.getId();
	}
	
	public String deleteEmployee(int employeeId) {
		EntityManager currentSession = entityManager.createEntityManager();
		Employee employee = currentSession.find(Employee.class, employeeId);
		currentSession.getTransaction().begin();
		currentSession.remove(employee);
		currentSession.getTransaction().commit();
		return "Employee deleted";
	}
	
}
