package com.osworks.osworksapi.api.controller;

import com.osworks.osworksapi.domain.model.ServiceOrder;
import com.osworks.osworksapi.domain.repository.ServiceOrderRepository;
import com.osworks.osworksapi.domain.service.ServiceOrderManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ServiceOrder create(@RequestBody ServiceOrder serviceOrder) {
        return serviceOrderManagement.create(serviceOrder);
    }
}