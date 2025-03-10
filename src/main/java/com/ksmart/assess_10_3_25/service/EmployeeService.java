package com.ksmart.assess_10_3_25.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ksmart.assess_10_3_25.contract.EmployeeDTO;
import com.ksmart.assess_10_3_25.contract.Response;
import com.ksmart.assess_10_3_25.exception.UserIdNotFoundException;
import com.ksmart.assess_10_3_25.model.Employee;
import com.ksmart.assess_10_3_25.repository.EmployeeRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeService {

    private final EmployeeRepo empRepo;

   // private final UserIdNotFoundException idNotFound;

    ModelMapper modelMapper;
    public void addNewEmployee(EmployeeDTO empDto) {
        
      empRepo.save(modelMapper.map(empDto, Employee.class));
       // throw new UnsupportedOperationException("Unimplemented method 'addNewEmployee'");
    }
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();
    }
    public Employee getEmp(Integer empid) {
       if(empRepo.existsById(empid)){
        return  empRepo.findAllByEmpid(empid);

       }
       else 
        throw new UserIdNotFoundException(empid);
    }
    public Employee updateEmployee(Integer empid, EmployeeDTO empDto) {
       Employee emp = empRepo.findById(empid).orElseThrow(()-> new UserIdNotFoundException(empid));
       modelMapper.map(empDto, emp);
       return  empRepo.save(emp);
    }
    public String deleteEmpById(Integer empid) {
        if(empRepo.existsById(empid)){
          empRepo.deleteById(empid);
          return "deleted";

           }
         
         else 
        throw new UserIdNotFoundException(empid);
              //  return null;
    }
    

    
}
