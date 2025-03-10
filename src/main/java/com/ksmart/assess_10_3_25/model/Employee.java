package com.ksmart.assess_10_3_25.model;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer empid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure ID is auto-generated
    private Integer empid; 
    private String name;
    private String designation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate joiningDate;
    private double salary;
    
}
/*

CREATE SEQUENCE employee_empid_seq START 100;
ALTER TABLE employee ALTER COLUMN empid SET DEFAULT nextval('employee_empid_seq');

*/