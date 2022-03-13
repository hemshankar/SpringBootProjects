package com.hem.testspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hem.testspring.model.Employee;
import com.hem.testspring.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService empSer;
	
	public EmployeeController(EmployeeService ser) {
		super();
		empSer = ser;		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
		Employee e = empSer.getEmployee(id);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(empSer.saveEmployee(emp), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee emp){
		return new ResponseEntity<Employee>(empSer.updateEmployee(id, emp), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(empSer.getAllEmployees(), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id){
		return new ResponseEntity<Employee>(empSer.deleteEmployee(id), HttpStatus.OK);
	}
}
