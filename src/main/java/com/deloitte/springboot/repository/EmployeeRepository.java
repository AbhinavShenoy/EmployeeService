package com.deloitte.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	

}
