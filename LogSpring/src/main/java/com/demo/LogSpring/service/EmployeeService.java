package com.demo.LogSpring.service;

import java.util.List;

import com.demo.LogSpring.model.Employee;
import com.demo.LogSpring.repository.EmployeeRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
// Annotation
@Service
// Class implementing DepartmentService class

public class EmployeeService {

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}
	
	 @Autowired
	    private EmployeeRepository empRepo;
	 
	    // Save operation
	    public Employee saveDepartment(Employee department)
	    {
	        return empRepo.save(department);
	    }
	 
	    // Read operation
	    public List<Employee> fetchDepartmentList()
	    {
	        return (List<Employee>)
	        		empRepo.findAll();
	    }

	

}
