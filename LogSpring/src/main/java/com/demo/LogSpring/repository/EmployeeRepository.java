package com.demo.LogSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.LogSpring.model.Employee;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//Employee findById(int emp_id);

}