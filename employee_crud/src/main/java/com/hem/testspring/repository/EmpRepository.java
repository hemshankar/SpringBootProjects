package com.hem.testspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hem.testspring.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
