package com.ksmart.assess_10_3_25.contract;

import java.sql.Date;

import lombok.Data;

@Data
public class EmployeeDTO {

    private String name;
    private String designation;
    private Date dateOfBirth;
    private Date joiningDate;
    private double salary;
    
}
