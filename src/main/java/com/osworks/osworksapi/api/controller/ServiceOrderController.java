package com.osworks.osworksapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.osworks.osworksapi.domain.model.ServiceOrder;
import com.osworks.osworksapi.domain.repository.ServiceOrderRepository;
import com.osworks.osworksapi.domain.service.ServiceOrderManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {
    
    @Autowired
    private ServiceOrderManagementService serviceOrderManagement;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ServiceOrder create(@Valid @RequestBody ServiceOrder serviceOrder) {
        return serviceOrderManagement.create(serviceOrder);
    }

    @GetMapping
    private List<ServiceOrder> show() {
        return serviceOrderRepository.findAll();
    }

    @GetMapping("/{serviceOrderId}")
    private ResponseEntity<ServiceOrder> search(@PathVariable Long serviceOrderId) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(serviceOrderId);

        if(serviceOrder.isPresent()) {
            return ResponseEntity.ok(serviceOrder.get());
        }

        return ResponseEntity.notFound().build();
    }
}