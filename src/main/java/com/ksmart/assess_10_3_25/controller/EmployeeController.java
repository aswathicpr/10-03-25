package com.ksmart.assess_10_3_25.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ksmart.assess_10_3_25.contract.EmployeeDTO;
import com.ksmart.assess_10_3_25.contract.Response;
import com.ksmart.assess_10_3_25.model.Employee;
import com.ksmart.assess_10_3_25.service.EmployeeService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
     EmployeeService empService;

    @PostMapping("/addemployee")
    public String addEmployee(@RequestBody EmployeeDTO empDto) {
        empService.addNewEmployee(empDto);
        
        return "Employee added";
    }
    
    @GetMapping("/getallemployee")
    public List<Employee> getAllEmployee() {

        return  empService.getAllEmployee();
    }
    @GetMapping("/getemployeebyid")
    public Employee getEmployeeById(@RequestParam Integer empid) {
         return  empService.getEmp(empid);
        
    }

    @PutMapping("/updateemployee/{empid}")
    public ResponseEntity<Response<?>> updateEmployee(@PathVariable Integer empid, @RequestBody EmployeeDTO empDto) {
        empService.updateEmployee(empid, empDto);
        
       // return ResponseEntity.status(HttpStatus.ACCEPTED).body(Response.builder().build());
        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(Employee.class).message("updated").build());

    }
    @DeleteMapping("/deletebyid")
    public void deleteById(Integer empid){
        empService.deleteEmpById(empid);
      //  return "Employee with "+empid +" deleted";
    }
    
}
