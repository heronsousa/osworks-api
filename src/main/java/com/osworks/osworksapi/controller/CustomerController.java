package com.osworks.osworksapi.controller;

import java.util.List;
import java.util.Optional;

import com.osworks.osworksapi.domain.model.Customer;
import com.osworks.osworksapi.domain.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> search(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if(customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }

        return ResponseEntity.notFound().build();
    }
}