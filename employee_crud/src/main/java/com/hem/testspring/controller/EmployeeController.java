package com.hem.testspring.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hem.testspring.model.Employee;
import com.hem.testspring.service.EmployeeService;
import org.springframework.web.multipart.MultipartFile;

import static java.lang.System.out;

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

	@PostMapping("{id}/image")
	public ResponseEntity<?> addImage(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile mFile){
		String fileName = mFile.getOriginalFilename();
		try{
			String folder = "C:\\hsahu\\Personal\\Personal\\Projects\\SpringBoot\\Projects\\employee_crud\\images";
			mFile.transferTo( new File(folder + "/" + fileName));
			empSer.addImage(id, fileName);
		}catch(Exception e){
			return new ResponseEntity(Arrays.stream(e.getStackTrace()).toList(), HttpStatus.INTERNAL_SERVER_ERROR);
		};
		return ResponseEntity.ok("File " + mFile + " uploaded successfully.");
	}

	@PostMapping("upload")
	public ResponseEntity<?> uploadImage(@RequestParam("fname") MultipartFile mFile){
		String fileName = mFile.getOriginalFilename();
		try{
			String folder = "C:\\hsahu\\Personal\\Personal\\Projects\\SpringBoot\\Projects\\employee_crud\\images";
			mFile.transferTo( new File(folder + "/" + fileName));
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity(Arrays.stream(e.getStackTrace()).toList(), HttpStatus.INTERNAL_SERVER_ERROR);
		};
		return ResponseEntity.ok("File " + mFile + " uploaded successfully.");
	}
}
