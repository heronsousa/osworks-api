package com.osworks.osworksapi.domain.service;

import com.osworks.osworksapi.domain.model.Customer;
import com.osworks.osworksapi.domain.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRegisterService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }     

    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}