package com.demo.LogSpring.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Importing required classes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.demo.LogSpring.Exception.ResourceNotFoundException;
import com.demo.LogSpring.model.Employee;
import com.demo.LogSpring.repository.EmployeeRepository;
import com.demo.LogSpring.service.EmployeeService;

//Annotation
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

//Class
public class EmployeeController {

	@Autowired private EmployeeService empServ;
	
	@Autowired private EmployeeRepository employeeRepository;

	// Save operation
//	@RequestMapping(value="/saveemployee", produces = "application/json", method=RequestMethod.POST)
	@PostMapping("/saveemployee")

	public Employee saveDepartment(@Validated @RequestBody Employee department)
		{
			return empServ.saveDepartment(department);
		}

	// Read operation
	
	@GetMapping("/saveemployee" )

	public List<Employee> fetchDepartmentList()
	{
		return empServ.fetchDepartmentList();
	}
	
	
	// get employee by id rest api
		@GetMapping("/saveemployee/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			return ResponseEntity.ok(employee);
		}
		
		
		// update employee rest api
		
		@PutMapping("/saveemployee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails){
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
//			employee.setEmp_id(employeeDetails.getEmp_id());
			employee.setEmail(employeeDetails.getEmail());
			employee.setPass(employeeDetails.getPass());
			
			Employee updatedEmployee = employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
		
		// delete employee rest api
		@DeleteMapping("/saveemployee/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			employeeRepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
}
