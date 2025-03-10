package com.ksmart.assess_10_3_25.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean

public ModelMapper mapper(){
    return new ModelMapper();
}
    
}
