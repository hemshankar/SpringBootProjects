package com.hem.testspring.service;

import java.util.List;

import com.hem.testspring.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee e);
	public Employee getEmployee(Integer id);
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(Integer id, Employee emp);
	public Employee deleteEmployee(Integer id);
	
}
