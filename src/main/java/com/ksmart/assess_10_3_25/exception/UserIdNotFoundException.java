package com.ksmart.assess_10_3_25.exception;

public class UserIdNotFoundException extends RuntimeException{
        public  UserIdNotFoundException(Integer empid){
            super("Employee with " + empid + " not found");
    }
    
}
