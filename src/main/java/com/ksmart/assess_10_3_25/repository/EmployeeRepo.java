package com.ksmart.assess_10_3_25.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksmart.assess_10_3_25.contract.EmployeeDTO;
import com.ksmart.assess_10_3_25.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findAllByEmpid(Integer empid);

    // @Query(nativeQuery = true, value = """
    // Select * from employee where designation=:designation
    
    //         """)
    // List<Map<String, Object>> findByDesignation(@Param("designation") String designation);


    @Query(nativeQuery = true, value = """
            
    SELECT *

    FROM employee as  emp WHERE emp.designation=:designation
            """)
    List<Employee> findByDesignation(String designation);

   
    @Query(nativeQuery = true, value = """
            
    SELECT emp.name, emp.salary

    FROM employee as  emp 
            """)
    List<Object[]> findNameSalary();

    
}
