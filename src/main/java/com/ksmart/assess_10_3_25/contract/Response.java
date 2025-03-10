package com.ksmart.assess_10_3_25.contract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {
    private String message;
    private T payload;
    
}
