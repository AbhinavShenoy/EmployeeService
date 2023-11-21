package com.deloitte.springboot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.springboot.model.DepartmentDTO;
import com.deloitte.springboot.model.Employee;

@FeignClient(name = "department-service" , url="localhost:8080")
public interface DepartmentFeignClient {

    @GetMapping("/departments/{id}")
    DepartmentDTO getDepartmentById(@PathVariable("id") Long id);
}
