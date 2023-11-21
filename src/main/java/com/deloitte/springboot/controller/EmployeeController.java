package com.deloitte.springboot.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.springboot.DepartmentFeignClient;
import com.deloitte.springboot.model.DepartmentDTO;
import com.deloitte.springboot.model.Employee;
import com.deloitte.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentFeignClient departmentFeignClient;

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable Long id) {
        // Retrieve employee from the database
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            // Call DepartmentService using FeignClient
            DepartmentDTO department = departmentFeignClient.getDepartmentById(employee.getDepartmentId());

            // Respond with employee details along with department info
            return ResponseEntity.ok("Employee details: " + employee.toString() + ", Department details: " + department.toString());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
