package com.deloitte.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name = "department_id")
	private Long departmentId;
 
 
public Long getId() {
	return employeeId;
}
public void setId(Long id) {
	this.employeeId = id;
}
public String getName() {
	return employeeName;
}
public void setName(String name) {
	this.employeeName = name;
}
public Long getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}
public Employee(Long id, String name, Long departmentId) {
	super();
	this.employeeId = id;
	this.employeeName = name;
	this.departmentId = departmentId;
}
 
public Employee() {
	
}

@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", departmentId="
			+ departmentId + "]";
}
 // Constructors, getters, setters...
}
