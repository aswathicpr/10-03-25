package com.ksmart.assess_10_3_25.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksmart.assess_10_3_25.model.Employee;
import com.ksmart.assess_10_3_25.service.CustomEmployeeService;
import com.ksmart.assess_10_3_25.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomEmployeeController {
     @Autowired
     CustomEmployeeService customService;

    @GetMapping("/getemployeebydesignation/{designation}")
    public List<Employee> getEmpByDesignation(@PathVariable String designation) {

        return  customService.getEmpByDesignation(designation);
    }
      @GetMapping("getnamesalary")
    public List<Object[]> getNameSalary() {
        return customService.getEmpNameAndSalary();
    }
    
    
}
