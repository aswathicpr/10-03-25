package com.ksmart.assess_10_3_25.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ksmart.assess_10_3_25.model.Employee;
import com.ksmart.assess_10_3_25.repository.EmployeeRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomEmployeeService {

    private final EmployeeRepo empRepo;
    public List<Employee> getEmpByDesignation(String designation) {
     return empRepo.findByDesignation(designation);
     //  throw new UnsupportedOperationException("Unimplemented method 'getEmpByDesignation'");
    }
     public List<Object[]> getEmpNameAndSalary() {
      return empRepo.findNameSalary();
    }

    
}
