package com.osworks.osworksapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.osworks.osworksapi.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    List<Customer> findByNameContaining(String name);
    Customer findByEmail(String email);
}