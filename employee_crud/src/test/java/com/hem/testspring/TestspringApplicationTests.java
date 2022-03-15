package com.hem.testspring;

import com.hem.testspring.model.Employee;
import com.hem.testspring.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.util.List;

@SpringBootTest
class TestspringApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	EmployeeService employeeService;

	@Test
	public void testEmpService(){

		Employee emp = employeeService.saveEmployee(new Employee(1, "Nikolas", "imgAddress"));
		AssertionErrors.assertNotNull("Checking if the Employee object got created", emp);

		List<Employee> empList = employeeService.getAllEmployees();
		Integer size1 = empList.size();
		AssertionErrors.assertTrue("Checking if the employeeList is empty or not", !empList.isEmpty());

		emp.setName("Tesla");
		employeeService.updateEmployee(emp.getId(), emp);
		AssertionErrors.assertEquals("Checking for successful update", "Tesla", emp.getName());

		emp = employeeService.getEmployee(emp.getId());
		AssertionErrors.assertEquals("Checking for successful fetch employeeID", "Tesla", emp.getName());

		Integer id = emp.getId();
		emp = null;
		emp = employeeService.deleteEmployee(id);
		AssertionErrors.assertNotNull("Checking delete works", emp);

		empList = employeeService.getAllEmployees();
		Integer size2 = empList.size();

		AssertionErrors.assertEquals("Checking it the employee got deleted using list size", size2 , size1 - 1);
	}

}
