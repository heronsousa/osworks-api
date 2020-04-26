package com.osworks.osworksapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.osworks.osworksapi.domain.model.Customer;
import com.osworks.osworksapi.domain.repository.CustomerRepository;
import com.osworks.osworksapi.domain.service.CustomerRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerRegisterService customerRegister;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@Valid @RequestBody Customer customer) {
        
        return customerRegister.save(customer);
    }
    

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> update(@PathVariable Long customerId, @Valid @RequestBody Customer customer) {
        if(!customerRepository.existsById(customerId)){
            return ResponseEntity.notFound().build();
        }
        
        customer.setId(customerId);
        customerRegister.save(customer);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable Long customerId) {
        if(!customerRepository.existsById(customerId)){
            return ResponseEntity.notFound().build();
        }

        customerRegister.delete(customerId);

        return ResponseEntity.ok().build();
    }
}