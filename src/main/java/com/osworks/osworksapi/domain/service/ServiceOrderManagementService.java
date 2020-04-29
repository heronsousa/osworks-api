package com.osworks.osworksapi.domain.service;

import java.time.LocalDateTime;

import com.osworks.osworksapi.domain.model.ServiceOrder;
import com.osworks.osworksapi.domain.model.ServiceOrderStatus;
import com.osworks.osworksapi.domain.repository.ServiceOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderManagementService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder create(ServiceOrder serviceOrder) {
        serviceOrder.setStatus(ServiceOrderStatus.ABERTA);
        serviceOrder.setOpeningDate(LocalDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }
}