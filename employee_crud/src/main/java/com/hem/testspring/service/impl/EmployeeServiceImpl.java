package com.hem.testspring.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hem.testspring.exceptions.ResourceNotFoundException;
import com.hem.testspring.model.Employee;
import com.hem.testspring.repository.EmpRepository;
import com.hem.testspring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmpRepository eRepo;
	public EmployeeServiceImpl(EmpRepository eRepo) {
		super();
		this.eRepo = eRepo;
	}
	
	@Override
	public Employee saveEmployee(Employee e) {
		return eRepo.save(e);
	}

	@Override
	public Employee getEmployee(Integer id) {
		Employee e = eRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return eRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Integer id, Employee emp) {
		Employee e = eRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		e.setName(emp.getName());
		return eRepo.save(e);
	}

	@Override
	public Employee deleteEmployee(Integer id) {
		Employee e = eRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		eRepo.deleteById(id);
		return e;
	}

	@Override
	public void addImage(Integer id, String fileName) {
		Employee e = eRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		e.setImage(fileName);
		eRepo.save(e);
	}
}
