package com.osworks.osworksapi.api.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperCofig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}