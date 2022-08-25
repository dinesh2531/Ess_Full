package com.demo.LogSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "emp_id")
	private int emp_id;
	
	@Column(name = "email")
	private  String email;
	
	@Column(name = "pass")
	private String pass;
	
	public Employee() {}
	
	
	
	public Employee(int emp_id, String email, String pass) {
	super();
	this.emp_id = emp_id;
	this.email = email;
	this.pass = pass;
}
	
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
