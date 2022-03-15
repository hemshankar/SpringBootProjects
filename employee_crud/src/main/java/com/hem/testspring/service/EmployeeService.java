package com.hem.testspring.service;

import java.util.List;

import com.hem.testspring.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee e);
	Employee getEmployee(Integer id);
	List<Employee> getAllEmployees();
	Employee updateEmployee(Integer id, Employee emp);
	Employee deleteEmployee(Integer id);
    void addImage(Integer id, String fileName);
}
