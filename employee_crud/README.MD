Project to perform CRUD operation using Spring Boot


Dependencies used: 
1. Spring Web
2. Lombok
3. Spring JPA
4. H2DB


Steps to use:
============ 
1. Download/Pull/Sync and build
2. Run the generated jar "java -jar employee_crud*.jar"
3. Go to http://localhost:8080/h2-console and Create the EMP table -> CREATE TABLE emp (id INT AUTO_INCREMENT  PRIMARY KEY,name VARCHAR(250) NOT NULL);
4. Call following APIs
	1. GET /employee -> lists all the employees 
	2. GET /employee/{id} -> returns details of employee with id: id
	2. POST /employee {"name": "Emp Name"} /employee -> adds Employee
	3. PUT  /employee/id {"name": "New Name"} /employee/{id} -> updates Employee with id: id 
	4. DELETE /employee/id -> Deletes the employee with ID: id 
