package com.osworks.osworksapi.controller;

import java.util.List;

import com.osworks.osworksapi.domain.model.Customer;
import com.osworks.osworksapi.domain.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> listar() {
        return customerRepository.findAll();
        // return customerRepository.findByName("Heron");
    }
}