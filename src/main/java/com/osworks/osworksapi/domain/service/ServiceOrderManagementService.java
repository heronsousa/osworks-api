package com.osworks.osworksapi.domain.service;

import java.time.OffsetDateTime;

import com.osworks.osworksapi.domain.exception.ServiceException;
import com.osworks.osworksapi.domain.model.Customer;
import com.osworks.osworksapi.domain.model.ServiceOrder;
import com.osworks.osworksapi.domain.model.ServiceOrderStatus;
import com.osworks.osworksapi.domain.repository.CustomerRepository;
import com.osworks.osworksapi.domain.repository.ServiceOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderManagementService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ServiceOrder create(ServiceOrder serviceOrder) {
        Customer customer = customerRepository.findById(serviceOrder.getCustomer().getId())
                            .orElseThrow(() -> new ServiceException("Cliente não encontrado."));

        serviceOrder.setCustomer(customer);
        serviceOrder.setStatus(ServiceOrderStatus.ABERTA);
        serviceOrder.setOpeningDate(OffsetDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }
}