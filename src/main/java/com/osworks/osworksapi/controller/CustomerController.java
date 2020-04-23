package com.osworks.osworksapi.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.osworks.osworksapi.domain.model.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/customers")
    public List<Customer> listar() {
        return manager.createQuery("from Customer", Customer.class).getResultList();
    }
}